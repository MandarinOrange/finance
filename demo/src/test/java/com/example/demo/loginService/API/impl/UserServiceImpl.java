package com.example.demo.loginService.API.impl;

import com.example.demo.Dao.userMapper;
import com.example.demo.bean.User;
import com.example.demo.loginService.API.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
    private userMapper UserMapper;
    @Transactional(propagation=Propagation.REQUIRED,readOnly = true)
    public User selectUserByuserName(String userName){
        return this.UserMapper.selectUserByuserName(userName);
    }
}
