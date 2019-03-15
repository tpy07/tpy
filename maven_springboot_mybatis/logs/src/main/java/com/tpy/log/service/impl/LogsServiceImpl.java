package com.tpy.log.service.impl;

import com.alibaba.fastjson.JSON;
import com.tpy.log.dao.LogsDao;
import com.tpy.log.dao.LogsDao_redis;
import com.tpy.log.model.Logs;
import com.tpy.log.model.Users;
import com.tpy.log.service.LogsService;
import com.tpy.log.service.UserService;
import com.tpy.log.util.PageBean;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    private LogsDao logsDao;
    @Autowired
    private StringRedisTemplate redis;
    @Override
    public List<Logs> querAll(int pages) {
        //查询redis缓存zset
        List<Logs> list=querAllRedisZset((pages-1)*3,(pages-1)*3+2);
        //判断redis缓存(zset)是否有数据
        if(list==null||list.size()<=0){
            //查询redis缓存list
            list=querAllRedis(pages);
            //判断redis缓存(list)是否有数据
            if(list==null||list.size()<=0){
                System.out.println("数据库查询");
                //如果list和zset都没有则进入数据库查询
                list=logsDao.selectAll();
                if(list==null||list.size()==0){
                    return null;
                }
                //向redis添加zset类型的数据
                addRedisZset(list);
                //向redis添加list类型的数据
                addRedis(list);
                //添加完之后再次查询缓存
                list=querAllRedisZset((pages-1)*3,(pages-1)*3+2);
                return list;
            }
            //如果redis(list)不为空泽将数据添加到zset类型中
            addRedisZset(list);
            //查询缓存reids的zset类型
            list=querAllRedisZset((pages-1)*3,(pages-1)*3+2);
        }
        return list;
    }

    @Override
    public int addlogs(Logs logs) {
        if(logs.getBname()==null||logs.getBname().equals("")||logs.getBcontext()==null||logs.getBcontext().equals("")||logs.getUserName()==null||logs.getUserName().equals("")){
            return -1;
        }
        int i=logsDao.addLogs(logs);
        //如果数据添加成功,则向缓存添加数据
        if(i>0){
            List<Logs> list=new ArrayList<Logs>();
            list.add(logs);
            addRedis(list);
            addRedisZset(list);
        }
        return i;
    }

    @Override
    public Logs selectByBid(Logs log) {
        Logs l=logsDao.selectByBid(log);
        if(l!=null&&l.getUserName()!=null&&l.getBid()!=null){
            //如果该条数据不为空,则修redis缓存zset的改点击数量(scope)
            updateScope(log);
            return l;
        }
        return null;
    }

    @Override
    public int selectBySum(Logs logs) {
        try {
            int sum=logsDao.selectSum(logs);
            System.out.println("总数====="+sum);
            return sum;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Logs> selectByBname(Logs logs,int page) {
        String[] bname=new String[2];
        bname[0]=logs.getBname();
        List<Logs> list=querAllRedisZset(0,-1 ,bname);
        if(list==null||list.size()==0){
            return logsDao.selectByBname(logs,page);
        }
        return list;
    }

    @Override
    public int delete(Logs logs) {
        int i=logsDao.delete(logs);
        //如果删除成功则删除redis缓存
        if(i>0){
            delRedis("LOGS_TABLE");
            delRedis("LOGS_TABLE_ZSET");
        }
        return i;
    }

    /**
     * 定时任务
     * cron表达式配置的完整格式: 秒 分 时 日 月 周 年;如:0 0 12 * * ? 2018(2018年每天12:00执行)
     * @Scheduled只能支持六位不支持七位所以年需要省略掉 秒 分 时 日 月 周 如:0 0 12 * * ?
     * ps:定时更新数据库的点击数量
     */
    @Scheduled(cron = "0 0 00 * * ?")
    public void runTask(){
        System.out.println("定时任务!!");

        List<Logs> list=querAllRedisZset(0, -1);
        for (Logs log:list){
            logsDao.updateclickRcte(log);
        }
    }
    //查询redis缓存为list类型的数据
    public List<Logs> querAllRedis(int page){
        System.out.println("缓存查询===========");
        List<Logs> logsList=new ArrayList<Logs>();
        List<String> list=redis.opsForList().range("LOGS_TABLE",page ,page+2);
        for (String str:list){
            Logs log = JSON.toJavaObject(JSON.parseObject(str),Logs.class );
            logsList.add(log);
        }
        return logsList;
    }
    //添加redis缓存类型为list
    public int addRedis(List<Logs> logsList){
        List<String> list=new ArrayList<String>();
        for (Logs log:logsList){
            list.add(JSON.toJSONString(log));
        }
        redis.opsForList().rightPushAll("LOGS_TABLE",list);
        System.out.println("缓存添加成功=============================");
        return  1;
    }
    //删除redis的key
    public boolean delRedis(String table){
        return redis.delete(table);
    }
    //查询redis缓存为zset类型的数据
    public List<Logs> querAllRedisZset(int page,int end,String... bname){
        Set<String> log=redis.opsForZSet().reverseRange("LOGS_TABLE_ZSET", page, end);
        List<Logs> logsList=new ArrayList<Logs>();
        for (String lo:log){
            DecimalFormat df = new DecimalFormat("0");
            //将数量(scope)转换成string类型并且去除小数点改为整数
            String scope=df.format(redis.opsForZSet().score("LOGS_TABLE_ZSET",lo));
            Logs l=JSON.toJavaObject(JSON.parseObject(lo),Logs.class );
            l.setClickRcte(scope);
            if(bname.length==0){
                logsList.add(l);
            }else if(bname.length>=1){
                String name=bname[0];
                System.out.println("1=============");
                if(l.getBname().contains(name)||l.getBcontext().contains(name)){
                    logsList.add(l);
                }
            }


        }
        return  logsList;
    }
    //添加redis缓存类型为zset
    public int addRedisZset(List<Logs> logsList){
        ZSetOperations.TypedTuple<String> logs = null;
        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<ZSetOperations.TypedTuple<String>>();
        for (Logs log:logsList){
            logs=new DefaultTypedTuple<String>(JSON.toJSONString(log),log.getClickRcte()==null||log.getClickRcte().equals("")? 0d:Double.parseDouble(log.getClickRcte()));
            tuples.add(logs);
        }
        redis.opsForZSet().add("LOGS_TABLE_ZSET",tuples);
        System.out.println("ZSET缓存添加成功=============================");
        return  1;
    }
    //修改redis缓存类型为zset的scope
    public void updateScope(Logs log){
        System.out.println("修改点击率");
        List<String> list=redis.opsForList().range("LOGS_TABLE",0 ,-1);
        for (String str:list){
            Logs l = JSON.toJavaObject(JSON.parseObject(str),Logs.class );
            if(l.getBid().equals(log.getBid())){
                log=l;
                break;
            }
        }
        //修改scope 返回值为修改的值, 注:incrementScore(key,value(该条必须为zset已有的值并且一致,
        // 否则会像redis缓存添加一条数据),scope)
        redis.opsForZSet().incrementScore("LOGS_TABLE_ZSET",JSON.toJSONString(log),1d);
    }
}
