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
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long managerNum;
    private String managerName;
    private String managerPwd;
    private String managerRight;
    private String telephoneNum;


    public Manager(){};

}
