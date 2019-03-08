package com.tpy.log.service.impl;

import com.tpy.log.dao.LogsDao;
import com.tpy.log.model.Logs;
import com.tpy.log.model.Users;
import com.tpy.log.service.LogsService;
import com.tpy.log.service.UserService;
import com.tpy.log.util.PageBean;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    private LogsDao logsDao;
    @Override
    public List<Logs> querAll(int pages) {
        List<Logs> list=logsDao.querAll((pages-1)*3);

        return list;
    }

    @Override
    public int addlogs(Logs logs) {
        if(logs.getBname()==null||logs.getBname().equals("")||logs.getBcontext()==null||logs.getBcontext().equals("")||logs.getUserName()==null||logs.getUserName().equals("")){
            return -1;
        }
        int i=logsDao.addLogs(logs);
        return i;
    }

    @Override
    public Logs selectByBid(Logs log) {
        return logsDao.selectByBid(log);
    }

    @Override
    public int selectBySum(Logs logs) {
        System.out.println(logs==null);
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
}
