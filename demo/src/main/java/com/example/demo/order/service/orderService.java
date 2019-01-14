package com.example.demo.order.service;

import com.example.demo.bean.Audit;

import java.util.List;

public interface orderService {
    public List<Audit> selectAuditByUserNum(long userNum);
}
