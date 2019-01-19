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
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionNum;
    private long payer;
    private long payee;
    private float transactionTime;
    private double transactionAmount;
    private String note;
    private long checkNum;

    public Transaction(){};
    public Transaction(long checkNum,long payer,long payee,double transationAmount){
        this.checkNum=checkNum;
        this.payer = payer;
        this.payee = payee;
        this.transactionAmount=transationAmount;

    }
}
