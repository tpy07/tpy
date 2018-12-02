package com.tpy.log.service.impl;

import com.tpy.log.dao.UserDao;
import com.tpy.log.model.Users;
import com.tpy.log.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int selectByUserNameAndPwd(Users user) {
        List<Users> list=userDao.selectByUserNameAndPwd(user);
        if (list.size()>0){
            return 1;
        }else if (list.size()<=0){
            return -1;
        }
        return 1;
    }

    @Override
    public int add(Users user) {
        if(user.getUserName()==null||user.getUserName().equals("")||user.getPassword()==null||user.getPassword().equals("")){
            return -1;
        }
        int i=userDao.add(user);
        System.out.println(i);
        return i;
    }

    @Override
    public int selectByUserName(Users user) {
        if(user.getUserName()==null||user.getUserName().equals("")||user.getPassword()==null||user.getPassword().equals("")){
            return 0;
        }
        int uid=userDao.selectByUserNameAndPwd(user).get(0).getUid();
        return uid;
    }
}
