package com.example.demo.circulator.service;

import com.example.demo.Dao.paymentMapper;
import com.example.demo.Dao.productMapper;
import com.example.demo.Dao.usageDateMapper;
import com.example.demo.bean.Product;
import com.example.demo.bean.Repayment;
import com.example.demo.bean.UsageDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EPR_CirService extends CirService{
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
            Repayment repayment = paymentMapper.selectPepaymentBycheckNum(checkNum);
            if(usageDate!=null){return -2;}
            int year = usageDate.getYear();
            double amount = usageDate.getAmount();
            long productNum = usageDate.getProductNum();

            Product product = productMapper.selectProductByProductNum(productNum);
            if(product==null)return -3;
            float intrate = product.getIntrate();
            double rep_amount = 0;
            if(repayment!=null)
                repayment.getRepAmount();
            intrate /= 12;
            int month = year*12;
            double next_principal_and_interest = amount/month + (amount - rep_amount) * intrate;
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
            intrate /= 12;
            int month = year * 12;
            double first_principal_and_interest = amount/month + amount*intrate;
            double last_principal_and_interest = amount/month + amount*(1-(month-1)/month)*intrate;
            double principal_and_interest = (first_principal_and_interest + last_principal_and_interest)*month/2;
            return principal_and_interest;
        }catch(Exception e){
            e.printStackTrace();
        }finally {

        }
        return -1;
    }
}
