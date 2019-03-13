package com.tpy.log.service;

import com.tpy.log.model.Users;

import java.util.List;

public interface UserService {
    public int selectByUserNameAndPwd(Users user);
    public int add(Users user);
    public String selectByUserName(Users user);
}
