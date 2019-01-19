package com.example.demo.circulator.service;

import com.example.demo.bean.Audit;
import com.example.demo.bean.Product;
import com.example.demo.bean.Repayment;
import com.example.demo.bean.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayCirService {
    @Autowired
    private com.example.demo.Dao.auditMapper auditMapper;
    @Autowired
    private com.example.demo.Dao.paymentMapper paymentMapper;
    @Autowired
    private com.example.demo.Dao.transMapper transMapper;
    @Autowired
    private com.example.demo.Dao.productMapper productMapper;


    public int pay_EPR_AmountCirculator(long checkNum,long userNum,double pay) {
        try {
            Repayment repayment = paymentMapper.selectPepaymentBycheckNum(checkNum);
            Audit audit = auditMapper.selectAudioByCheckNum(checkNum);
            double repamount = 0;
            long productNum = audit.getProductNum();
            long userNum2 = audit.getUserNum();
            double amount = audit.getAmount();

            if(userNum2!=userNum)return -1;
            Product product = productMapper.selectProductByProductNum(productNum);
            if (product == null)
                return -3;
            long bankNum = product.getBankNum();
            int count = transMapper.selectCount()+1;
            Transaction transaction = new Transaction();
            transaction.setCheckNum(checkNum);
            transaction.setTransactionNum(count);
            transaction.setPayer(userNum);
            transaction.setPayee(bankNum);
            transaction.setTransactionAmount(pay);
            transMapper.addTransaction(transaction);

            double intrate = product.getIntrate();

            if (repayment != null) {
                double rep_amount = repayment.getRepSum();
                repamount = pay - (amount - repamount) * intrate;
                repayment.setRepAmount(repamount);
                repayment.setCheckNum(checkNum);
                repayment.setRepSum(pay + rep_amount);
                paymentMapper.updateRepayment(repayment);
            } else {
                repayment = new Repayment();
                //repamount = pay - amount * intrate;
                repayment.setRepAmount(repamount);
                repayment.setCheckNum(checkNum);
                repayment.setRepSum(pay);
                paymentMapper.addRepayment(repayment);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return 0;
    }

    public int pay_EPAIR_AmountCirculator(long checkNum,long userNum,double pay){
        try{
            Audit audit= auditMapper.selectAudioByCheckNum(checkNum);
            int year = audit.getYear();
            double amount = audit.getAmount();
            long productNum = audit.getProductNum();

            Product product = productMapper.selectProductByProductNum(productNum);
            if(product==null)return -3;
            float intrate = product.getIntrate();
            double rep_amount = 0;

            //double not_rep_amount = amount - rep_amount;
            intrate /= 12;
            int month = year*12;
            double rep = Math.pow((1+intrate),month)/(Math.pow((1+intrate),month)-1);
            double next_principal_and_interest = rep * intrate * amount;

            long userNum2 = audit.getUserNum();
            long bankNum = product.getBankNum();

            if(userNum2!=userNum)return -1;
            int count = transMapper.selectCount()+1;
            Transaction transaction = new Transaction();
            transaction.setCheckNum(checkNum);
            transaction.setTransactionNum(count);
            transaction.setPayer(userNum);
            transaction.setPayee(bankNum);
            transaction.setTransactionAmount(pay);
            transMapper.addTransaction(transaction);

            Repayment repayment = paymentMapper.selectPepaymentBycheckNum(checkNum);
            double repSum = next_principal_and_interest;
            if(repayment!=null){
                repSum += repayment.getRepSum();
                repayment.setRepSum(repSum);
                repayment.setCheckNum(checkNum);
                paymentMapper.updateRepayment(repayment);
            }else{
                Repayment repayment1 = new Repayment();
                repayment1.setRepSum(repSum);
                repayment1.setCheckNum(checkNum);
                paymentMapper.addRepayment(repayment1);
            }
            return 1;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
        }
        return 0;
    }


    public  int payAmountCirculator(long checkNum,long userNum,double pay){
        try{
            Audit audit = auditMapper.selectAudioByCheckNum(checkNum);
            if(audit==null){return  -2;}
            int equation = audit.getEquation();
            if(equation == 1){
                return pay_EPAIR_AmountCirculator(checkNum,userNum,pay);
            }else if(equation == 2){
                return pay_EPR_AmountCirculator(checkNum,userNum,pay);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return 0;
    }

}
