package com.example.demo.bean;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Bank {
    private int bankNum;
    private String bankName;
    private String contact;//联系方式


    public Bank(){};
}
