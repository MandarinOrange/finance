package com.example.demo.loginService.API.impl;

import com.example.demo.bean.User;
import org.springframework.stereotype.Service;

@Service
public abstract class UserService {
    public User selectUserByuserName(String userName){return null;}
    public User selectUserBytelephoneNum(String telephoneNum){return null;}
    public void insertUser(long userNum, String userName, String userPwd, String registerTime, String userRight){}
    public long count(){return 0;}
}
