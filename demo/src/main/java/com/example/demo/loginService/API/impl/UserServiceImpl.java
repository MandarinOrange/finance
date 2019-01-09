package com.example.demo.loginService.API.impl;

import com.example.demo.Dao.userMapper;
import com.example.demo.bean.User;
import com.example.demo.loginService.API.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
    @Autowired
    private userMapper UserMapper;
    @Transactional(propagation=Propagation.REQUIRED,readOnly = true)
    public User selectUserByuserName(String userName){

        return this.UserMapper.selectUserByuserName(userName);
    }
    @Transactional(propagation=Propagation.REQUIRED,readOnly = true)
    public User selectUserBytelephoneNum(String telephoneNum){
        return this.UserMapper.selectUserBytelephoneNum(telephoneNum);
    }
    @Transactional(propagation=Propagation.REQUIRED,readOnly = false)
    public void insertUser(long userNum,String userName,String userPwd,String registerTime,String userRight){
        this.UserMapper.insertUser(userNum,userName,userPwd,registerTime,userRight);
    }
    @Transactional(propagation=Propagation.REQUIRED,readOnly = true)
    public long count(){
        return this.UserMapper.count();
    }

}
