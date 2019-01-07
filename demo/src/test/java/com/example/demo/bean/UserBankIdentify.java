package com.example.demo.bean;

import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class UserBankIdentify {
    private String userNum;
    private String bankAccount;
    private short bankAccountIdentify;
}
