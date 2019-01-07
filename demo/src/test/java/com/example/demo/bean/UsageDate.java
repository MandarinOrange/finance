package com.example.demo.bean;

import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class UsageDate {
    private long checkNum;
    private long productNum;
    private long userNum;
    private String bankAccount;
    private int bankNum;
    private int year;
    private float amount;
    private String startTime;
    private int equation;
}
