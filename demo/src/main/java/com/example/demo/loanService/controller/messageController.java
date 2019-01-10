package com.example.demo.loanService.controller;


import com.example.demo.Dao.auditMapper;
import com.example.demo.bean.Audit;
import com.example.demo.loanService.service.message;
import com.example.demo.util.nowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class messageController extends HttpServlet {
    @Autowired
    auditMapper auditMapper;
    private nowTime nowTime=new nowTime();
    private message message=new message();

    @RequestMapping("")//填写贷款基本信息的界面
    public String doPost(HttpServletResponse response, HttpServletRequest request){
        long num=1;//从登陆那里得到登陆者的序号
        Audit audit=new Audit();
        audit.setUserNum(num);
        audit.setAmount(Double.parseDouble(request.getParameter("amount")));
        audit.setYear(Integer.parseInt(request.getParameter("year")));
        audit.setBankAccount(request.getParameter("bankAccount"));
        audit.setEquation(Integer.parseInt(request.getParameter("equation")));
        audit.setApplyTime(nowTime.nowTime());
        audit.setUserNum(Long.parseLong("d"));
        message.message(audit);
        return "";//审核界面
    }

}