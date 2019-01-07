package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String managerNum;
    private String managerName;
    private String managerPwd;
    private String managerRight;
    private String telephoneNum;

    public Manager(){};

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getManagerRight() {
        return managerRight;
    }

    public void setManagerRight(String managerRight) {
        this.managerRight = managerRight;
    }

    public String getManagerPwd() {
        return managerPwd;
    }

    public void setManagerPwd(String managerPwd) {
        this.managerPwd = managerPwd;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerNum() {
        return managerNum;
    }

    public void setManagerNum(String managerNum) {
        this.managerNum = managerNum;
    }
}
