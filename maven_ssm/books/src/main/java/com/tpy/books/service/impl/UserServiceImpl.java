package com.tpy.books.service.impl;

import com.tpy.books.dao.UserDao;
import com.tpy.books.model.Users;
import com.tpy.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Users selectByUserNameAndPwd(Users user) {
        try {
            Users users=userDao.selectByUserNameAndPwd(user).get(0);
            return users;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int addUser(Users user) {
        try {
            if(user==null||user.getUserName()==null||user.getPassword()==null||"".equals(user.getUserName())||"".equals(user.getPassword())){
                return -1;
            }else{
                userDao.addUser(user);
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
