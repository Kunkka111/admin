package com.example.test.serviceImpl;

import com.example.test.pojo.User;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User loginIn(String acoount, String password) {
        return userMapper.getInfo(acoount,password);
    }

    @Override
    public User queryUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int addUser(User user) {
        int aFlag = userMapper.insertUser(user);
        return aFlag;
    }

    @Override
    public int deleteUser(String id) {
        int dFlag = userMapper.deleteUser(id);
        return dFlag;
    }

    @Override
    public int updateUser(User user) {
        int mFlag = userMapper.updateUser(user);
        return mFlag;
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void resetKey(){
        userMapper.resetKey();
    }
}
