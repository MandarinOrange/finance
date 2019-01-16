package com.example.demo.loanService.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.Dao.auditMapper;
import com.example.demo.bean.Audit;
import com.example.demo.bean.User;
import com.example.demo.loanService.service.messageService;
import com.example.demo.util.nowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class messageController extends HttpServlet {
    @Autowired
    private messageService message;

    @RequestMapping(value = "/loan",method = RequestMethod.POST)//填写贷款基本信息的界面

    //判断填写银行卡号是否是已认证

    public void doPost(HttpServletResponse response, HttpServletRequest request)throws IOException {
        nowTime nowTime=new nowTime();
        int equation = 1;
        HttpSession session=request.getSession();
        User user=new User();
        user=(User)session.getAttribute("user");
        long num=user.getUserNum();
        Audit audit=new Audit();
        audit.setUserNum(num);
        audit.setAmount(Double.parseDouble(request.getParameter("amount")));
        audit.setYear(Integer.parseInt(request.getParameter("year")));
        audit.setBankAccount(request.getParameter("bankAccount"));
        audit.setEquation(Integer.parseInt(request.getParameter("equation")));
        audit.setApplyTime(nowTime.nowTime());
        //audit.setUserNum(num);
        message.message(audit);
        response.sendRedirect("waitAuditing.html");
    }

}
