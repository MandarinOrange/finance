package com.example.demo.circulator.service;

import com.example.demo.Dao.paymentMapper;
import com.example.demo.Dao.transMapper;
import com.example.demo.Dao.usageDateMapper;
import com.example.demo.bean.Repayment;
import com.example.demo.bean.Transaction;
import com.example.demo.bean.UsageDate;

public class PayCirService {
    private usageDateMapper usageDateMapper;
    private paymentMapper paymentMapper;
    private transMapper transMapper;

    public int payAmountCirculator(long checkNum,double pay){
        try{
            Repayment repayment = paymentMapper.selectPepaymentBycheckNum(checkNum);
            UsageDate usageDate= usageDateMapper.selectUsageDateByCheckNum(checkNum);
            double repamount = repayment.getRepAmount();
            long userNum = usageDate.getUserNum();
            int bankNum = usageDate.getBankNum();
            double amount = usageDate.getAmount();
            int year = usageDate.getYear();

            Transaction transaction = new Transaction(checkNum,userNum,bankNum,pay);
            transMapper.addTransaction(transaction);

            repamount = pay - amount/(year*12);
            repayment.setRepAmount(repamount);
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
