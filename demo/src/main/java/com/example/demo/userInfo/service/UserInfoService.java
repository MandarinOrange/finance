package com.example.demo.userInfo.service;

import com.example.demo.bean.User;

public interface UserInfoService {
    User selectUserByuserName(String userName);
}
