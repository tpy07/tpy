package com.tpy.books.action;

import com.tpy.books.model.Users;
import com.tpy.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserAction {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest req;
    @RequestMapping("/login")
    @ResponseBody
    public Users login(Users user){
        try {
            Users users=userService.selectByUserNameAndPwd(user);
            if(users.getUid()>0){
                session.setAttribute("uname",users.getUserName());
            }
            return users;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/addUser")
    @ResponseBody
    public int addUser(Users user){
        int i=-1;
        try {
            i=userService.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return i;
    }
    @RequestMapping("/log")
    public String log(){
        try {
            //获取上一个url地址(方便登录的精确跳转)
            String url=req.getHeader("Referer");
            int indexof=url.indexOf("b");
            url=url.substring(indexof+1);
            int endindexof=url.indexOf("/");
            url=url.substring(endindexof+1);
            req.setAttribute("url",url);
            return "myaccount";
        }catch (Exception e){
            return "myaccount";
        }

    }
    @RequestMapping("/reg")
    public String res(){
        //获取上一个url地址(方便注册的精确跳转)
        try {
            String url=req.getHeader("Referer");
            if(url==null){
                return "register";
            }
            int indexof=url.indexOf("b");
            url=url.substring(indexof+1);
            int endindexof=url.indexOf("/");
            url=url.substring(endindexof+1);
            System.out.println(url);
            req.setAttribute("url",url);
        }catch (Exception e){
            return "register";
        }
        return "register";
    }

}
