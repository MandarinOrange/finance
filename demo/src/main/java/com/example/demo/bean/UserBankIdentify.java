package com.example.demo.bean;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class UserBankIdentify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userNum;
    private String bankAccount;
    private short bankAccountIdentify;
    private String idNum;
    private String trueName;
    private String telephoneNum;

    public UserBankIdentify(){};
}
