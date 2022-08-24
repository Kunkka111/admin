package com.example.test.serviceImpl;

import com.example.test.pojo.Admin;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    UserMapper userMapper;

    /**
     * 登录验证
     * @param name
     * @param password
     * @return
     */
    @Override
    public Admin loginIn(String acoount, String password) {
        return userMapper.getInfo(acoount,password);
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @Override
    public Admin queryUserById(String id) {
        return userMapper.selectUserById(id);
    }


    /**
     * 新增用户
     * @param admin
     * @return
     */
    @Override
    public int addUser(Admin admin) {
        int aFlag = userMapper.insertUser(admin);
        return aFlag;
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
//    @Override
//    public int dropUser(String id) {
//        int dFlag = userMapper.deleteUser(id);
//        return dFlag;
//    }
//
//
//    /**
//     * 修改用户信息
//     * remark：实际上还是根据用户ID修改用户信息
//     * @param admin
//     * @return
//     */
//    @Override
//    public int modifyUser(Admin admin) {
//        int mFlag = userMapper.updateUser(admin);
//        return mFlag;
//    }
//
//    /**
//     * 查询所有用户信息
//     * @return
//     */
    @Override
    public List<Admin> queryAllUser() {
        return userMapper.getAllUser();
    }
}
