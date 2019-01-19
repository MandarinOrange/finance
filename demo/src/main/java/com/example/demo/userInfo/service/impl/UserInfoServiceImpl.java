package com.example.demo.userInfo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.Dao.userMapper;
import com.example.demo.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    userMapper userMapper;
    @Override
    public User selectUserByuserName(String userName) {
        return userMapper.selectUserByuserName(userName);
    }
}
