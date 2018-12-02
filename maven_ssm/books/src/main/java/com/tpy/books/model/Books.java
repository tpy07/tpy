package com.tpy.books.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Books implements Serializable {
    private int bid;//书籍id
    private String bookName;//书名
    private Users uid;//出售此书的用户
    private double bookPrice;//单价
    private float discount;//折扣
    private int sellNumber;//销售量
    private String bookContext;//书籍的详细内容
    private String bookImage;//书籍图片
    private Timestamp cretatTime;//添加时间

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public int getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(int sellNumber) {
        this.sellNumber = sellNumber;
    }

    public String getBookContext() {
        return bookContext;
    }

    public void setBookContext(String bookContext) {
        this.bookContext = bookContext;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Users getUid() {
        return uid;
    }

    public void setUid(Users uid) {
        this.uid = uid;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Timestamp getCretatTime() {
        return cretatTime;
    }

    public void setCretatTime(Timestamp cretatTime) {
        this.cretatTime = cretatTime;
    }
}
