package com.tpy.log.dao;

import com.tpy.log.model.Logs;
import com.tpy.log.util.PageBean;
import com.tpy.log.util.SqlProvider;
import org.apache.ibatis.annotations.*;
import sun.rmi.runtime.Log;

import java.util.List;

@Mapper
public interface LogsDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from bugs limit #{page},3")
    public List<Logs> querAll(int page);
    /**
     * 根据bname或者bcontext模糊查询
     * @param logs
     * @return
     */
    @Select("select * from bugs where bname like CONCAT('%',#{logs.bname},'%')  or bcontext like CONCAT('%',#{logs.bcontext},'%') limit #{page},3")
    public List<Logs> selectByBname(@Param("logs") Logs logs,int page);

    /**
     * 查询数量
     * @param logs
     * @return
     */
    @SelectProvider(type=SqlProvider.class,method = "selectSum")
    public int selectSum(Logs logs);
    /**
     * 添加
     * @param log
     * @return
     */
    @Insert("insert into bugs(bname,bcontext,userName) values(#{bname},#{bcontext},#{userName})")
    @Options(useGeneratedKeys = true,keyProperty = "bid")
    public int addLogs(Logs log);

    /**
     * 根据bid查询
     * @param log
     * @return
     */
    @Select("select * from bugs where bid=#{bid}")
    public Logs selectByBid(Logs log);

    /**
     * 根据bid删除记录
     * @param logs
     * @return
     */
    @Delete("delete from bugs where bid=#{bid}")
    public int delete(Logs logs);
}
