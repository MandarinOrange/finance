package com.example.demo.register.controller;


import com.example.demo.bean.User;
import com.example.demo.bean.UserBankIdentify;
import com.example.demo.register.identify;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class bankCardController extends HttpServlet {

    private identify identify=new identify();

    @RequestMapping("/binding")//卡号绑定界面
    public String doPost(HttpServletResponse response, HttpServletRequest request){
        HttpSession session=request.getSession();
        User user=new User();
        user=(User)session.getAttribute("user");
        try{
            long num=user.getUserNum();
            short result=0;
            UserBankIdentify userBankIdentify=new UserBankIdentify();
            userBankIdentify.setBankAccount(request.getParameter("bankAccount"));
            userBankIdentify.setTrueName(request.getParameter("realname"));
            userBankIdentify.setIdNum(request.getParameter("idNum"));
            userBankIdentify.setTelephoneNum(request.getParameter("phoneNum"));
            userBankIdentify.setUserNum(num);
            userBankIdentify.setBankAccountIdentify(result);
            identify.identify(userBankIdentify);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "../首页/index.html";//返回首页
    }
}
