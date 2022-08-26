package com.example.test.service;

import com.example.test.pojo.User;

import java.util.List;

public interface UserService {

    //登录时信息核对
    User loginIn(String account, String password);

    //根据ID查询用户信息
    User queryUserById(String id);

    //插入新的用户
    int addUser(User user);

    //删除用户
    int deleteUser(String id);

    //修改用户
    int updateUser(User user);

    //查询所有用户
    List<User> findAllUser();

}
