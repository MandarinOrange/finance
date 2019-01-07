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
    private int checkNum;
    private  int userNum;
    private  double amount;
    private  String applyTime;
    private String bankAccount;
    private int checkState;
    private int contractNum;
    private short isSignContract;
    private  int productNum;
    private  int year;
    private int equation;

    public Audit(){};
}
