package com.example.demo.bean;

import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class UsageDate {
    private String checkNum;
    private String productNum;
    private String userNum;
    private String bankAccount;
    private String bankNum;
    private int year;
    private float amount;
    private String startTime;
}
