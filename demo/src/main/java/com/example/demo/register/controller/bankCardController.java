package com.example.demo.register.controller;


import com.example.demo.Dao.userBankIdMapper;
import com.example.demo.bean.UserBankIdentify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class bankCardController extends HttpServlet {

    @Autowired
    userBankIdMapper userBankIdMapper;

    @RequestMapping("")//手机表单界面
    public String doPost(HttpServletResponse response, HttpServletRequest request){
        try{
            long num=1;//获取得到userNum
            UserBankIdentify userBankIdentify=new UserBankIdentify();
            userBankIdentify.setBankAccount(request.getParameter("mobile"));
            userBankIdentify.setTrueName(request.getParameter("realname"));
            userBankIdentify.setIdNum(request.getParameter("idNum"));
            userBankIdentify.setTelephoneNum(request.getParameter("phoneNum"));
            userBankIdentify.setUserNum(num);
            userBankIdMapper.addUserBankIdentify(userBankIdentify);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";//返回首页
    }
}
