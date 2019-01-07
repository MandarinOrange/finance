package com.example.demo.bean;

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
    private int userNum;
    private String userName;
    private String userPwd;
    private String userRight;
    private String trueName;
    private String idNum;
    private String telephoneNum;
    private String address;
    private int isIdentify;
    private String registerTime;

    public User(){};
}
