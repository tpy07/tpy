package com.tpy.log.dao;

import com.tpy.log.model.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface UserDao {
    /**
     * 根据用户名或密码查询用户信息
     * @param user
     * @return
     */
    @Select("select * from users where BINARY userName=#{userName} and BINARY password=#{password}")
    public List<Users> selectByUserNameAndPwd(Users user);

    /**
     * 注册用户
     * @param user
     * @return >0注册成功 <0注册失败
     */
    @Insert("insert into users(userName,password,sex,city) values(#{userName},#{password},#{sex},#{city})")
    @Options(useGeneratedKeys = true,keyProperty = "uid")
    public int add(Users user);
}
