package com.example.test.mapper;

import com.example.test.pojo.User;

import java.util.List;

public interface UserMapper {

    //登录时信息核对
    User getInfo(String account, String password);

    //根据ID查询用户信息
    User selectUserById(String id);

    //插入新的用户
    int insertUser(User user);

    //删除用户
    int deleteUser(String id);

    //重置数据库主键自增
    void resetKey();

    //修改用户
    int updateUser(User user);

    //查询所有用户
    List<User> getAllUser();

}
