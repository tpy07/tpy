package com.tpy.log.service.impl;

import com.alibaba.fastjson.JSON;
import com.tpy.log.dao.UserDao;
import com.tpy.log.model.Users;
import com.tpy.log.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private StringRedisTemplate redis;
    @Override
    public int selectByUserNameAndPwd(Users user) {
        Users i=loginRedis(user);
        if(i==null){
            List<Users> list=userDao.selectByUserNameAndPwd(user);
            System.out.println("数据库登录");
            if (list.size()>0){
                addRedis(list);
                return 1;
            }else if (list.size()<=0){
                return -1;
            }
        }else{
            if (i.getUserName()!=null&&i.getPassword()!=null)
            return 1;
        }
        return  -1;
    }

    @Override
    public int add(Users user) {
        if(user.getUserName()==null||user.getUserName().equals("")||user.getPassword()==null||user.getPassword().equals("")){
            return -1;
        }
        int i=userDao.add(user);
        if(i>0){
            List<Users> list=new ArrayList<Users>();
            list.add(user);
            addRedis(list);
        }
        return i;
    }

    @Override
    public String selectByUserName(Users user) {
        if(user.getUserName()==null||user.getUserName().equals("")||user.getPassword()==null||user.getPassword().equals("")){
            return "";
        }
        Users u=loginRedis(user);
        String uid="";
        if(u==null)
           uid=userDao.selectByUserNameAndPwd(user).get(0).getUid();
        else if(u.getUserName()!=null&&u.getPassword()!=null)
            uid=loginRedis(user).getUid();
        return uid;
    }
    public Users loginRedis(Users user){
        System.out.println("登录进入缓存");
        Set<Object> k=redis.opsForHash().keys("USER_TABLE");
        if(k.size()<=0){
            return null;
        }
        for (Object o:k){
            Object obj=redis.opsForHash().get("USER_TABLE", o.toString());
           Users u=JSON.toJavaObject(JSON.parseObject(obj.toString()), Users.class);
            if(u.getUserName().equals(user.getUserName())&&u.getPassword().equals(user.getPassword())){
                return u;
            }
        }
        return null;
    }
    public void addRedis(List<Users> list){
        Map<String,String> users=new HashMap<String,String>();
        for (Users user:list)
            users.put(user.getUid(), JSON.toJSONString(user));

        redis.opsForHash().putAll("USER_TABLE", users);
    }
}
