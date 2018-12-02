package com.tpy.log.service;

import com.tpy.log.model.Logs;
import com.tpy.log.util.PageBean;

import java.util.List;

public interface LogsService {
    /**
     * 查询所有
     * @return
     */
    public List<Logs> querAll(int page);

    /**
     * 添加
     * @param logs
     * @return >0添加成功<0添加失败
     */
    public int addlogs(Logs logs);

    /**
     * 根据bid查询
     * @param log
     * @return
     */
    public Logs selectByBid(Logs log);
    public int selectBySum(Logs logs);
    /**
     * 根据bname或者bcontext模糊查询
     * @param logs
     * @return
     */
    public List<Logs> selectByBname(Logs logs,int page);

    /**
     * 根据bid删除记录
     * @param logs
     * @return
     */
    public int delete(Logs logs);
}
