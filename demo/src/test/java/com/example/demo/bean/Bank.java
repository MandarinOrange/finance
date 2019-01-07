package com.example.demo.bean;


import javax.persistence.*;

@Entity
public class Bank {
    private String bankNum;
    private String bankName;
    private String contact;//联系方式

    public Bank(){};

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
