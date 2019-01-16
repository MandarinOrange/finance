package com.example.demo.bankCard.service;

import com.example.demo.bean.UserBankIdentify;

import java.util.List;

public interface BankCardService {
    List<UserBankIdentify> selectUserBankByUserNum(long userNum);
}
