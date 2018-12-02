package com.tpy.books.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Users implements Serializable {
    private int uid;//用户id
    private String userName;//用户名
    private String password;//密码
    private int struts;//状态0正常1禁用
    private Timestamp cretatTime;//注册时间

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStruts() {
        return struts;
    }

    public void setStruts(int struts) {
        this.struts = struts;
    }

    public Timestamp getCretatTime() {
        return cretatTime;
    }

    public void setCretatTime(Timestamp cretatTime) {
        this.cretatTime = cretatTime;
    }
}
