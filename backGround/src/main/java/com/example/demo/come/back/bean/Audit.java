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
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long checkNum;
    private  long userNum;
    private  double amount;
    private  String applyTime;
    private String bankAccount;
    private int checkState;
    private long contractNum;
    private short isSignContract;
    private  long productNum;
    private  int year;
    private int equation;


    public Audit(){};
}
