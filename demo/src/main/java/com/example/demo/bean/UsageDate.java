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
public class UsageDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long checkNum;
    private long productNum;
    private long userNum;
    private String bankAccount;
    private int bankNum;
    private int year;
    private float amount;
    private String startTime;

    public UsageDate(){}
    private int equation;

    public int getYear() {
        return 0;
    }

    public long getProductNum() {
        return 0;
    }

    public double getAmount() {
        return amount;
    }

    public long getUserNum() {
        return userNum;
    }

    public int getBankNum() {
        return bankNum;
    }

}
