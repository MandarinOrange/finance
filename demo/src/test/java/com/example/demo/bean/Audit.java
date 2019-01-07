package com.example.demo.bean;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private long checkState;
    private long contractNum;
    private short isSignContract;
    private  long productNum;
    private  int year;
    private int equation;


    public Audit(){};
}
