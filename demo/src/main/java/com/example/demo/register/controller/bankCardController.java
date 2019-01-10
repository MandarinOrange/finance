package com.example.demo.register.controller;


import com.example.demo.bean.UserBankIdentify;
import com.example.demo.register.identify;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class bankCardController extends HttpServlet {

    private identify identify=new identify();

    @RequestMapping("/phone")//手机表单界面
    public String doPost(HttpServletResponse response, HttpServletRequest request){
        try{
            long num=1;//获取得到userNum
            short result=0;
            UserBankIdentify userBankIdentify=new UserBankIdentify();
            userBankIdentify.setBankAccount(request.getParameter("mobile"));
            userBankIdentify.setTrueName(request.getParameter("realname"));
            userBankIdentify.setIdNum(request.getParameter("idNum"));
            userBankIdentify.setTelephoneNum(request.getParameter("phoneNum"));
            userBankIdentify.setUserNum(num);
            userBankIdentify.setBankAccountIdentify(result);
            identify.identify(userBankIdentify);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";//返回首页
    }
}
