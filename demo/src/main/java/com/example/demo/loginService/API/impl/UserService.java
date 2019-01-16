package com.example.demo.loginService.API.impl;

import com.example.demo.bean.User;
import org.springframework.stereotype.Service;

@Service
public abstract class UserService {
    public User selectUserByuserName(String userName){return null;}
    public User selectUserBytelephoneNum(String telephoneNum){return null;}
    public void addUser(User users){}
    public long count(){return 0;}
}
