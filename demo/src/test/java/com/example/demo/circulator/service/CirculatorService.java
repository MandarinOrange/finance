package com.example.demo.circulator.service;

import com.example.demo.Dao.auditMapper;
import com.example.demo.Dao.productMapper;
import com.example.demo.Dao.usageDateMapper;
import com.example.demo.bean.Product;
import com.example.demo.bean.UsageDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

public class CirculatorService {
    @Autowired
    private com.example.demo.Dao.usageDateMapper usageDateMapper;
    private productMapper productMapper;

    @PostConstruct
    public void init(){}

    @Transactional //数据库与事物的一致性
    public double Equal_principal_and_interest_repaymentNextCirculator(long checkNum){
        UsageDate usageDate = usageDateMapper.selectUsageDateByCheckNum(checkNum);
        int year = usageDate.getYear();
        double amount = usageDate.getAmount();
        long productNum = usageDate.getProductNum();

        Product product = productMapper.selectProductByProductNum(productNum);
        float intrate = product.getIntrate();
        intrate /= 12;
        int month = year*12;
        double rep = Math.pow((1+intrate),month)/(Math.pow((1+intrate),month)-1);
        double next_principal_and_interest = rep * intrate * amount;
        return next_principal_and_interest;
    }

    public double Equal_principal_and_interest_repaymentSumCirculator(long productNum,double amount,int year){
        Product product = productMapper.selectProductByProductNum(productNum);
        float intrate = product.getIntrate();
        double rep = Math.pow((1+intrate),year)/(Math.pow((1+intrate),year)-1);
        double principal_and_interest = rep * intrate * amount * year;
        return principal_and_interest;
    }

    public double Equal_principal_repaymentNextCirculator(long checkNum){
        UsageDate usageDate = usageDateMapper.selectUsageDateByCheckNum(checkNum);
        int year = usageDate.getYear();
        double amount = usageDate.getAmount();
        long productNum = usageDate.getProductNum();

        Product product = productMapper.selectProductByProductNum(productNum);
        float intrate = product.getIntrate();
        double rep_amount = 0;
        intrate /= 12;
        int month = year*12;
        double next_principal_and_interest = amount/month + (amount - rep_amount) * intrate;
        return next_principal_and_interest;
    }

    public double Equal_principal_repaymentSumCirculator(long productNum,double amount,int year){
        Product product = productMapper.selectProductByProductNum(productNum);
        float intrate = product.getIntrate();
        intrate /= 12;
        int month = year * 12;
        double first_principal_and_interest = amount/month + amount*intrate;
        double last_principal_and_interest = amount/month + amount*(1-(month-1)/month)*intrate;
        double principal_and_interest = (first_principal_and_interest + last_principal_and_interest)*month/2;
        return principal_and_interest;
    }
}
