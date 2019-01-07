package com.example.demo.circulator.service;

import com.example.demo.Dao.productMapper;
import com.example.demo.Dao.usageDateMapper;
import com.example.demo.bean.Product;
import com.example.demo.bean.UsageDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

public class EPR_CirService extends CirService{
    @Autowired
    private usageDateMapper usageDateMapper;
    private productMapper productMapper;

    @Transactional //数据库与事物的一致性
    public double NextCirculator(long checkNum){
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

    public double SumCirculator(long productNum,double amount,int year){
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
