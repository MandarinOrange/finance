package com.example.demo.circulator.service;

import com.example.demo.Dao.paymentMapper;
import com.example.demo.Dao.productMapper;
import com.example.demo.Dao.transMapper;
import com.example.demo.Dao.usageDateMapper;
import com.example.demo.bean.Product;
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
    @Autowired
    private productMapper productMapper;


    public int pay_EPR_AmountCirculator(long checkNum,double pay) {
        try {
            Repayment repayment = paymentMapper.selectPepaymentBycheckNum(checkNum);
            UsageDate usageDate = usageDateMapper.selectUsageDateByCheckNum(checkNum);
            double repamount = 0;
            long productNum = usageDate.getProductNum();
            long userNum = usageDate.getUserNum();
            int bankNum = usageDate.getBankNum();
            double amount = usageDate.getAmount();

            if (repayment != null)
                repamount = repayment.getRepAmount();
            Product product = productMapper.selectProductByProductNum(productNum);
            if (product == null)
                return -3;

            Transaction transaction = new Transaction(checkNum, userNum, bankNum, pay);
            transMapper.addTransaction(transaction);

            double intrate = product.getIntrate();
            double rep_amount = repayment.getRepSum();
            repamount = pay - (amount - repamount) * intrate;
            repayment.setRepAmount(repamount);
            repayment.setRepSum(pay + rep_amount);
            if (repayment != null) {
                paymentMapper.updateRepayment(repayment);
            } else {
                paymentMapper.addRepayment(repayment);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return 0;
    }

    public int pay_EPAIR_AmountCirculator(long checkNum,double pay){
        try{
            UsageDate usageDate = usageDateMapper.selectUsageDateByCheckNum(checkNum);
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

            long userNum = usageDate.getUserNum();
            long bankNum = usageDate.getBankNum();

            Transaction transaction = new Transaction(checkNum,userNum,bankNum,next_principal_and_interest);
            transMapper.addTransaction(transaction);

            Repayment repayment = paymentMapper.selectPepaymentBycheckNum(checkNum);
            double repSum = next_principal_and_interest;
            if(repayment!=null){
                repSum += repayment.getRepSum();
                repayment.setRepSum(repSum);
                paymentMapper.updateRepayment(repayment);
            }else{
                paymentMapper.addRepayment(repayment);
            }
            return 1;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
        }
        return 0;
    }


    public  int payAmountCirculator(long checkNum,double pay){
        try{
            UsageDate usageDate = usageDateMapper.selectUsageDateByCheckNum(checkNum);
            if(usageDate==null){return  -2;}
            int equation = usageDate.getEquation();
            if(equation == 1){
                return pay_EPAIR_AmountCirculator(checkNum,pay);
            }else if(equation == 2){
                return pay_EPR_AmountCirculator(checkNum,pay);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return 0;
    }

}
