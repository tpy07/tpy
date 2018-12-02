package com.tpy.log.action;

import com.tpy.log.model.Users;
import com.tpy.log.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserAction {
    @Autowired
    private UserService userService;
    @Resource
    private HttpSession session;
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String add(Users user){
        int i=userService.add(user);
        return "index";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public int login(Users user){
        System.out.println(user.getUserName());
        int i=userService.selectByUserNameAndPwd(user);
        if(i==1){
            session.setAttribute("uname",user.getUserName());
        }
        return i;
    }
    @RequestMapping(value = "/exit")
    public String exit(){
        session.removeAttribute("uname");
        return "index";
    }
}
