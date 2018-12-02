package com.tpy.books.dao;

import com.tpy.books.model.Books;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookDao {
    /**
     * 根据销售量排序并且分页查询所有书
     * @param page 当前页
     * @return
     */
    @Select("select bid,bookName,bookImage,sellNumber,uid,bookContext,bookPrice,discount,createTime from book ORDER BY book.sellNumber desc limit #{page},2")
    @Results({
            @Result(column="uid",property = "uid",one = @One(select="com.tpy.books.dao.UserDao.selectByUid",fetchType= FetchType.EAGER))
    })
    public List<Books> querAllByLimt(@Param("page") int page);

    /**
     * 查询所有商品数量
     * @return
     */
    @Select("select count(uid) from book")
    public int selectSum();

    /**
     * 根据cid查询最新书籍
     * @return 三条数据
     */
    @Select("select bid,bookName,bookImage,sellNumber,uid,bookContext,bookPrice,discount,createTime from book ORDER BY book.bid desc LIMIT 3")
    public List<Books> selectByPioneer();
    @Select("select bid,bookName,sellNumber,uid,bookContext,bookPrice,discount,createTime from book WHERE discount>0")
    public List<Books> selectByDiscount();

    /**
     * 根据bid查询商品信息
     * @param bid
     * @return
     */
    @Select("select bid,bookName,sellNumber,bookImage,uid,bookContext,bookPrice,discount,createTime from book where bid=#{bid}")
    public Books selectByBid(@Param("bid") int bid);

    /**
     * 分页查询所有书籍
     * @param page
     * @return
     */
    @Select("select bid,bookName,bookImage,sellNumber,uid,bookContext,bookPrice,discount,createTime from book limit #{page},12")
    @Results({
            @Result(column="uid",property = "uid",one = @One(select="com.tpy.books.dao.UserDao.selectByUid",fetchType= FetchType.EAGER))
    })
    public List<Books> querAll(@Param("page")int page);
}
