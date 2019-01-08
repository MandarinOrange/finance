package com.example.demo.loginService.API;

import com.example.demo.bean.User;

public interface UserService {
    public User selectUserByuserName(String userName);
}
