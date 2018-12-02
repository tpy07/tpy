package com.tpy.books.dao;

import com.tpy.books.model.Users;
import com.tpy.books.util.SqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    /**
     * 根据用户名或密码查询用户信息
     * @param user
     * @return
     */
    @SelectProvider(type = SqlProvider.class,method = "selectByUserNameAndPwd")
    public List<Users> selectByUserNameAndPwd(@Param(value="user") Users user);

    /**
     * 根据用户id查询用户信息
     * @param uid
     * @return
     */
    @Select("select uid,userName,password,struts,createTime from users where uid=#{uid}")
    public Users selectByUid(@Param("uid") int uid);
    /**
     * t注册用户
     * @param user
     */
    @Insert("insert into users(userName,password) values(#{userName},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "uid")
    public void addUser(Users user);
}
