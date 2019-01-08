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
public class Repayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long checkNum;
    private double repAmount;
    private double repSum;

    public double getRepAmount() {
        return 0;
    }

    public void setRepAmount(double repamount) {
    }

    public void setRepSum(double pay) {
    }
}
