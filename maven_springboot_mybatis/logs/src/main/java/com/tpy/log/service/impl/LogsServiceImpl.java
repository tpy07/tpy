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

import java.util.*;

@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    private LogsDao logsDao;
    @Override
    public List<Logs> querAll(int pages) {
        List<Logs> list=querAllRedis((pages-1)*3);
        if(list==null||list.size()<=0){
            System.out.println("数据库查询");
            list=logsDao.querAll((pages-1));
            addRedis(logsDao.selectAll());
        }
        return list;
    }

    @Override
    public int addlogs(Logs logs) {
        if(logs.getBname()==null||logs.getBname().equals("")||logs.getBcontext()==null||logs.getBcontext().equals("")||logs.getUserName()==null||logs.getUserName().equals("")){
            return -1;
        }
        int i=logsDao.addLogs(logs);
        if(i>0){
            List<Logs> list=new ArrayList<Logs>();
            list.add(logs);
            addRedis(list);
        }
        return i;
    }

    @Override
    public Logs selectByBid(Logs log) {
        return logsDao.selectByBid(log);
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
        return logsDao.selectByBname(logs,page);
    }

    @Override
    public int delete(Logs logs) {
        int i=logsDao.delete(logs);
        if(i>0){
            delRedis("LOGS_TABLE");
        }
        return i;
    }

    /**
     * 定时任务
     * cron表达式配置的完整格式: 秒 分 时 日 月 周 年;如:0 0 12 * * ? 2018(2018年每天12:00执行)
     * @Scheduled只能支持六位不支持七位所以年需要省略掉 秒 分 时 日 月 周 如:0 0 12 * * ?
     */
    @Scheduled(cron = "0 00 00 * * ?")
    public void runTask(){
        System.out.println("定时任务!!");
    }
    @Autowired
    private StringRedisTemplate redis;
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
    public int addRedis(List<Logs> logsList){
        List<String> list=new ArrayList<String>();
        for (Logs log:logsList){
            list.add(JSON.toJSONString(log));
        }
        redis.opsForList().rightPushAll("LOGS_TABLE",list);
        System.out.println("缓存添加成功=============================");
        return  1;
    }
    public boolean delRedis(String table){
        return redis.delete(table);
    }
}
