package com.example.demo.come.back.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userNum;
    private String userName;
    private String userPwd;
    private String userRight;
    private String telephoneNum;
    private short isIdentify;
    private String address;
    private String registerTime;

    public User(){};


}
