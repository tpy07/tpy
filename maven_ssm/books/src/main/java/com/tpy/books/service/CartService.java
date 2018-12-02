package com.tpy.books.service;

import com.tpy.books.model.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
    /**
     * 查询该用户的购物车数量
     * @param userName
     * @return
     */
    public List<Cart> selectCartSum(String userName);

    /**
     * 添加购物车
     * @param cart
     * @return >0添加购物车 <0添加失败
     */
    public int addCart(Cart cart,String userName);
    public Object[] selectByUid(int page,String userName);
}
