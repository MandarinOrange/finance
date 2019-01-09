package com.example.demo.circulator.service;

import com.example.demo.Dao.paymentMapper;
import com.example.demo.Dao.productMapper;
import com.example.demo.Dao.usageDateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class CirService {

    @PostConstruct
    public void init(){}

    @Transactional //数据库与事物的一致性
    public double NextCirculator(long checkNum){return 0;}
    public double SumCirculator(long productNum,double amount,int year){return 0;}

}
