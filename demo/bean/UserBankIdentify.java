package com.example.demo.bean;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class UserBankIdentify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userName;
    private String bankAccount;
    private short bankAccountIdentify;

}
