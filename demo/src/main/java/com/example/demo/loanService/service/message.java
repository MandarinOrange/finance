package com.example.demo.loanService.service;

import com.example.demo.Dao.auditMapper;
import com.example.demo.bean.Audit;
import org.springframework.beans.factory.annotation.Autowired;

public class message {
    @Autowired
    auditMapper auditMapper;

    public void message(Audit audit){
        long contractNum=0;
        short isSignContrat=0;
        int checkState=0;
        audit.setContractNum(contractNum);
        audit.setIsSignContract(isSignContrat);
        audit.setCheckNum(auditMapper.selectBigCheckNum());
        audit.setCheckState(checkState);
        auditMapper.addAudit(audit);
    }
}
