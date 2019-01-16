package com.example.demo.bankCard.service.impl;

import com.example.demo.Dao.userBankIdMapper;
import com.example.demo.bankCard.service.BankCardService;
import com.example.demo.bean.User;
import com.example.demo.bean.UserBankIdentify;
import com.example.demo.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCardServiceImpl implements BankCardService {
    @Autowired
    userBankIdMapper userBankIdMapper;

    @Override
    public List<UserBankIdentify> selectUserBankByUserNum(long userNum) {
        return userBankIdMapper.selectUserBankByUserNum(userNum);
    }



}

