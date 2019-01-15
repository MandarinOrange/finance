package com.example.demo.order.service.impl;

import com.example.demo.Dao.auditMapper;
import com.example.demo.bean.Audit;
import com.example.demo.order.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class orderServiceImpl implements orderService {
    @Autowired
    public auditMapper auditMapper;
    @Override
    public List<Audit> selectAuditByUserNum(long userNum){
        return auditMapper.selectAuditByUserNum(userNum);
    }
}
