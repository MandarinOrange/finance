package com.example.demo.circulator.service;

import com.example.demo.Dao.paymentMapper;
import com.example.demo.Dao.transMapper;
import com.example.demo.Dao.usageDateMapper;
import com.example.demo.bean.Repayment;
import com.example.demo.bean.Transaction;
import com.example.demo.bean.UsageDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayCirService {
    @Autowired
    private usageDateMapper usageDateMapper;
    @Autowired
    private paymentMapper paymentMapper;
    @Autowired
    private transMapper transMapper;

    public int payAmountCirculator(long checkNum,double pay){
        try{
            Repayment repayment = paymentMapper.selectPepaymentBycheckNum(checkNum);
            UsageDate usageDate= usageDateMapper.selectUsageDateByCheckNum(checkNum);
            if(usageDate!=null)return -2;
            double rep_amount = 0;
            if(repayment!=null)
                repayment.getRepAmount();
            long userNum = usageDate.getUserNum();
            int bankNum = usageDate.getBankNum();
            double amount = usageDate.getAmount();
            int year = usageDate.getYear();

            Transaction transaction = new Transaction(checkNum,userNum,bankNum,pay);
            transMapper.addTransaction(transaction);

            rep_amount = pay - amount/(year*12);
            repayment.setRepAmount(rep_amount);
            repayment.setRepSum(pay);
            paymentMapper.updateRepayment(repayment);
            return 1;
        }catch(Exception e){
            e.printStackTrace();
        }finally {


        }
        return 0;
    }
}
