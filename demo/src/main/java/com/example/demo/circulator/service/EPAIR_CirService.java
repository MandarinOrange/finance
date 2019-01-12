package com.example.demo.circulator.service;

import com.example.demo.Dao.paymentMapper;
import com.example.demo.Dao.productMapper;
import com.example.demo.Dao.usageDateMapper;
import com.example.demo.bean.Product;
import com.example.demo.bean.UsageDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EPAIR_CirService extends CirService{
    @Autowired
    private usageDateMapper usageDateMapper;
    @Autowired
    private paymentMapper paymentMapper;
    @Autowired
    private productMapper productMapper;

    @Transactional //数据库与事物的一致性
    public double NextCirculator(long checkNum){
        try{
            UsageDate usageDate = usageDateMapper.selectUsageDateByCheckNum(checkNum);
            if(usageDate==null)return -2;
            int year = usageDate.getYear();
            double amount = usageDate.getAmount();
            long productNum = usageDate.getProductNum();

            Product product = productMapper.selectProductByProductNum(productNum);
            if(product==null)return -3;
            float intrate = product.getIntrate();
            double rep_amount = 0;

            //double not_rep_amount = amount - rep_amount;
            intrate /= 12;
            int month = year*12;
            double rep = Math.pow((1+intrate),month)/(Math.pow((1+intrate),month)-1);
            double next_principal_and_interest = rep * intrate * amount;
            return next_principal_and_interest;
        }catch(Exception e){
            e.printStackTrace();
        }finally {


        }
        return -1;
    }

    public double SumCirculator(long productNum,double amount,int year){
        try{
            Product product = productMapper.selectProductByProductNum(productNum);
            if(product==null)return -3;
            float intrate = product.getIntrate();
            double rep = Math.pow((1+intrate),year)/(Math.pow((1+intrate),year)-1);
            double principal_and_interest = rep * intrate * amount * year;
            return principal_and_interest;
        }catch(Exception e){
            e.printStackTrace();
        }finally {

        }
        return -1;
    }
    public double SumCirculator( float intrate,double amount,int year){
        try{
            double rep = Math.pow((1+intrate),year)/(Math.pow((1+intrate),year)-1);
            double principal_and_interest = rep * intrate * amount * year;
            return principal_and_interest;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
        }
        return -1;
    }
}
