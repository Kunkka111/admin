package com.example.test.service;

import com.example.test.pojo.Admin;

import java.util.List;

public interface UserService {

    //登录时信息核对
    Admin loginIn(String account, String password);

    //根据ID查询用户信息
    Admin queryUserById(String id);

    //插入新的用户
    int addUser(Admin admin);

//    //删除用户
//    int dropUser(String id);
//
//    //修改用户
//    int modifyUser(Admin admin);
//
    //查询所有用户
    List<Admin> queryAllUser();

}
