package com.tpy.books.util;

import com.tpy.books.model.Users;

import java.util.Map;

public class SqlProvider {
    /**
     *为userdao里面的selectByUserNameAndPwd方法动态赋值sql
     * @param
     * @return
     */
    public String selectByUserNameAndPwd(Map<String,Users> param){
        StringBuffer sql=new StringBuffer("select uid,userName,password,struts,createTime from users where 1=1");

        Users user=param.get("user");
        System.out.println("user======================="+user.getUserName());
        if(user!=null){
            System.out.println("asdasd===========");
            if(user.getUserName()!=null&&!"".equals(user.getUserName())){
                sql.append(" and userName = '"+user.getUserName()+"'");
            }
            if(user.getPassword()!=null&&!"".equals(user.getPassword())){
                sql.append(" and password = '"+user.getPassword()+"'");
            }
        }
        System.out.println("sql========"+sql.toString());
        return sql.toString();
    }
}
