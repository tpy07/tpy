package com.tpy.books.action;

import com.tpy.books.model.Cart;
import com.tpy.books.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
@RequestMapping("/cart")
public class CartAction {
    @Autowired
    private CartService cartService;
    @Autowired
    private HttpSession session;
    @Resource
    private HttpServletRequest req;
    @RequestMapping(value = "/selectSum",method = RequestMethod.POST)
    @ResponseBody
    public List<Cart> selectCartSum(String userName){
        try {
            List<Cart> list=cartService.selectCartSum(userName);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping(value = "/addCart",method = RequestMethod.POST)
    @ResponseBody
    public int addCart(Cart cart){
        String userName=session.getAttribute("uname").toString();
        int i=cartService.addCart(cart,userName);
        return i;
    }
    @RequestMapping(value = "/selectByUid")
    public String selectByUid(int page){
        try {
            String userName=session.getAttribute("uname").toString();
            Object[] obj=cartService.selectByUid(page,userName);
            req.setAttribute("cart",obj);
        }catch (Exception e){
            e.printStackTrace();return "cart";
        }
        return "cart";
    }
}
