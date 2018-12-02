package com.tpy.books.dao;

import com.tpy.books.model.Cart;
import com.tpy.books.model.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CartDao {
    /**
     * 查询该用户的购物车数量
     * @param cart
     * @return
     */
    @Select("select cid,uid,bid,number,createTime from cart where uid=#{uid}")
    @Results({
            @Result(column="bid",property = "bid",one = @One(select="com.tpy.books.dao.BookDao.selectByBid",fetchType= FetchType.EAGER))
    })
    public List<Cart> selectCartSum(Cart cart);

    /**
     * 添加购物车
     * @param cart
     */
    @Insert("insert into cart(uid,bid,number) value(#{uid},#{bid.bid},#{number})")
    @Options(useGeneratedKeys = true,keyProperty = "cid")
    public void addCart(Cart cart);

    /**
     * 根据用户分页查询商品
     * @param cart
     * @param page
     * @return
     */
    @Select("select cid,uid,bid,number,createTime from cart where uid=#{cart.uid} limit #{page},3")
    @Results({
            @Result(column="bid",property = "bid",one = @One(select="com.tpy.books.dao.BookDao.selectByBid",fetchType= FetchType.EAGER))
    })
    public List<Cart> selectByUid(@Param("cart") Cart cart,@Param("page") int page);
}
