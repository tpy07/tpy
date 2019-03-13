package com.tpy.log.model;

import java.io.Serializable;
import java.util.Date;

public class Logs implements Serializable {
    private String bid;
    private String bname;
    private String bcontext;
    private String userName;
    private Date createTime;
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBcontext() {
        return bcontext;
    }

    public void setBcontext(String bcontext) {
        this.bcontext = bcontext;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
