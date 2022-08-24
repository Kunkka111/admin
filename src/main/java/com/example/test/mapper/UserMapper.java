package com.example.test.mapper;

import com.example.test.pojo.Admin;

import java.util.List;

public interface UserMapper {

    //登录时信息核对
    Admin getInfo(String account, String password);

    //根据ID查询用户信息
    Admin selectUserById(String id);

    //插入新的用户
    int insertUser(Admin admin);

    //删除用户
//    int deleteUser(String id);
//
//    //修改用户
//    int updateUser(Admin admin);
//
    //查询所有用户
    List<Admin> getAllUser();

}
