package com.tpy.log.util;

import com.tpy.log.model.Logs;

public class SqlProvider {
    /**
     * 为logsDao类里面的selectSum方法动态赋值sql
     * @param logs
     * @return
     */
    public String selectSum(Logs logs){
        StringBuffer sql=new StringBuffer("select count(*) from bugs where 1=1");

        if(logs!=null){
            System.out.println(logs.getBname());
            if(!logs.getBname().equals("")&&logs.getBname()!=null){
                sql.append(" and bname like '%"+logs.getBname()+"%'");
            }
            if(!logs.getBcontext().equals("")&&logs.getBcontext()!=null){
                sql.append(" or bcontext like '%"+logs.getBcontext()+"%'");
            }
        }
        System.out.println("sql==="+sql.toString());
        return sql.toString();
    }
}
