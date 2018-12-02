package com.tpy.books.service.impl;

import com.tpy.books.dao.CartDao;
import com.tpy.books.dao.UserDao;
import com.tpy.books.model.Cart;
import com.tpy.books.model.Users;
import com.tpy.books.service.CartService;
import com.tpy.books.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private UserDao userDao;
    @Override
    public List<Cart> selectCartSum(String userName) {
        try {
            if(userName!=null||!"".equals(userName)){
                Cart cart=new Cart();
                Users user=new Users();
                user.setUserName(userName);
                int id=userDao.selectByUserNameAndPwd(user).get(0).getUid();
                if(id>0){
                    cart.setUid(id);
                    List<Cart> list = cartDao.selectCartSum(cart);
                    return list;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int addCart(Cart cart,String userName) {
        try {
            Users user=new Users();
            user.setUserName(userName);
            int uid=userDao.selectByUserNameAndPwd(user).get(0).getUid();
            cart.setUid(uid);
            cartDao.addCart(cart);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public Object[] selectByUid(int page, String userName) {
        try {
            Users user=new Users();
            user.setUserName(userName);
            int uid=userDao.selectByUserNameAndPwd(user).get(0).getUid();

            Cart cart=new Cart();
            cart.setUid(uid);
            System.out.println(cart.getUid()+"=======getuid=======");
            List<Cart> list=cartDao.selectByUid(cart,(page-1)*3);
            PageBean pagebean=new PageBean(page,selectCartSum(userName).size(),3);
            Object[] obj=new Object[2];
            obj[0]=list;
            obj[1]=pagebean;
            return obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
