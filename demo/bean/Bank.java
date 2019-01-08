package com.example.demo.bean;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Bank {
    @Id
    private int bankNum;
    private String bankName;
    private String contact;//联系方式


    public Bank(){};
}
