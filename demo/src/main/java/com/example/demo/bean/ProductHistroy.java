package com.example.demo.bean;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class ProductHistroy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productNum;
    private int bankNum;
    private long managerNum;
    private String productName;
    private String category;
    private float intrate;
    private String productDescription;
    private String upLoadTime;  //数据库是小写的uploadTime
    private String deleteTime;
    private String alterTime;

    public ProductHistroy(){};

    public long getManagerNum() {
        return managerNum;
    }

    public void setManagerNum(long managerNum) {
        this.managerNum = managerNum;
    }

    public long getProductNum() {
        return productNum;
    }

    public void setProductNum(long productNum) {
        this.productNum = productNum;
    }

    public String getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(String alterTime) {
        this.alterTime = alterTime;
    }


    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getUpLoadTime() {
        return upLoadTime;
    }

    public void setUpLoadTime(String upLoadTime) {
        this.upLoadTime = upLoadTime;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getIntrate() {
        return intrate;
    }

    public void setIntrate(float intrate) {
        this.intrate = intrate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getBankNum() {
        return bankNum;
    }

    public void setBankNum(int bankNum) {
        this.bankNum = bankNum;
    }
}
