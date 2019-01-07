package com.example.demo.bean;


import javax.persistence.*;


@Entity
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String checkNum;
    private  String userNum;
    private  float amount;
    private  String applyTime;
    private String bankAccount;
    private int checkState;
    private String contractNum;
    private short isSignContract;
    private  String productNum;
    private  int year;

    public Audit(){};

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public short getIsSignContract() {
        return isSignContract;
    }

    public void setIsSignContract(short isSignContract) {
        this.isSignContract = isSignContract;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public int getCheckState() {
        return checkState;
    }

    public void setCheckState(int checkState) {
        this.checkState = checkState;
    }

    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }
}
