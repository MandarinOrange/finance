package com.example.demo.order.service.impl;

import com.example.demo.Dao.auditMapper;
import com.example.demo.bean.Audit;
import com.example.demo.order.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class orderServiceImpl implements orderService {
    @Autowired
    auditMapper auditMapper;
    @Override
    public List<Audit> selectAuditByUserNum(long userNum){
        return auditMapper.selectAuditByUserNum(userNum);
    }
    public List<Audit> selectAudByName(long userNum){
        return auditMapper.selectAudByNum(userNum);
    }
}
