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
    private int productNum;
    private int bankNum;
    private String productName;
    private String category;
    private float intrate;
    private String productDescription;
    private String upLoadTime;
    private String deleteTime;
    private String alterTime;

    public ProductHistroy(){};

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
