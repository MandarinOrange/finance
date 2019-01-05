package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String transaction;
    private String payer;
    private String payee;
    private float transactionTime;
    private float transactionAmount;
    private String note;

    public transaction(){};

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public float getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(float transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
}
