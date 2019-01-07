package com.example.demo.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Repayment {
    private long checkNum;
    private double repAmount;
    private double repSum;

}
