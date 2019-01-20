package com.example.demo.userCenter.service;

import com.example.demo.bean.User;

public interface UserInfoService {
    User selectUserByuserName(String userName);

    void updateUser(User user);
}
