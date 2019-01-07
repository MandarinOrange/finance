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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productNum;
    private String productName;
    private String category;
    private float intrate;
    private int bankNum;
    private String productDescription;
    private String pictureAddress;

    public Product(){};

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getBankNum() {
        return bankNum;
    }

    public void setBankNum(int bankNum) {
        this.bankNum = bankNum;
    }

    public float getIntrate() {
        return intrate;
    }

    public void setIntrate(float intrate) {
        this.intrate = intrate;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
