package com.tpy.books.model;

import java.awt.print.Book;
import java.io.Serializable;
import java.sql.Timestamp;

public class Cart implements Serializable {
    private int cid;//购物车id
    private int uid;//购买此商品的用户
    private Books bid;//书籍
    private int number;//数量
    private Timestamp cretatTime;//添加时间

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Books getBid() {
        return bid;
    }

    public void setBid(Books bid) {
        this.bid = bid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Timestamp getCretatTime() {
        return cretatTime;
    }

    public void setCretatTime(Timestamp cretatTime) {
        this.cretatTime = cretatTime;
    }
}
