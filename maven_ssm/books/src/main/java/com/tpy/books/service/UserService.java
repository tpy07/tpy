package com.tpy.books.service;

import com.tpy.books.model.Users;

import java.util.List;

public interface UserService {
    /**
     * 根据用户名或密码查询用户信息
     * @param user
     * @return
     */
    public Users selectByUserNameAndPwd(Users user);

    /**
     * 注册用户
     * @param user
     * @return >0注册成功 <0注册失败
     */
    public int addUser(Users user);
}
