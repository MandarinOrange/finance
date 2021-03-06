package com.example.demo.loanService.service;

import com.example.demo.bean.Audit;
import com.example.demo.Dao.auditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class messageService {
    @Autowired
    auditMapper auditMapper;

    public void message(Audit audit){
        long contractNum=0;
        short isSignContrat=0;
        int checkState=0;
        long count = auditMapper.selectCount()+1;
        audit.setCheckNum(count);
        audit.setContractNum(contractNum);
        audit.setIsSignContract(isSignContrat);
        //audit.setCheckNum(auditMapper.selectBigCheckNum());
        audit.setCheckState(checkState);
        auditMapper.addAudit(audit);
    }
}
