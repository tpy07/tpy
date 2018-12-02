package com.tpy.log.service.impl;

import com.tpy.log.dao.LogsDao;
import com.tpy.log.model.Logs;
import com.tpy.log.model.Users;
import com.tpy.log.service.LogsService;
import com.tpy.log.service.UserService;
import com.tpy.log.util.PageBean;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
