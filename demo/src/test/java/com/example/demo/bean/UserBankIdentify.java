package com.example.demo.bean;

import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class UserBankIdentify {
    private String userName;
    private String bankAccount;
    private short bankAccountIdentify;

}
