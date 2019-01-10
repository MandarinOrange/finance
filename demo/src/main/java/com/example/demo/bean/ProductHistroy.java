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
    private long bankNum;
    private long managerNum;
    private String productName;
    private String category;
    private float intrate;
    private String productDescription;
    private String upLoadTime;  //数据库是小写的uploadTime
    private String deleteTime;
    private String alterTime;

    public ProductHistroy(){};


}
