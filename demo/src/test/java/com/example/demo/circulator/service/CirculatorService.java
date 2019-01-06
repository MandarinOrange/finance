package com.example.demo.circulator.service;

import com.example.demo.Dao.auditMapper;
import com.example.demo.Dao.productMapper;
import com.example.demo.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

public class CirculatorService {
    @Autowired
    private productMapper productMapper;
    private auditMapper auditMapper;

    @PostConstruct
    public void init(){}

    @Transactional //数据库与事物的一致性
    public double countSumCirculator(String userNum,String productNum,float amount,int year){
        Product product  = productMapper.selectProductIntrateByProductNum(productNum);
        float intrate = product.getIntrate();
        return intrate;
    }
}
