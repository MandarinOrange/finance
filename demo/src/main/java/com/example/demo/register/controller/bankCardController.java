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
import java.io.IOException;

@Controller
public class bankCardController extends HttpServlet {

    private identify identify=new identify();

    @RequestMapping("/binding")//卡号绑定界面
    public void doPost(HttpServletResponse response, HttpServletRequest request)throws IOException {
        HttpSession session=request.getSession();
        long userNum=(long)session.getAttribute("user");
        try{
            short result=0;
            UserBankIdentify userBankIdentify=new UserBankIdentify();
            userBankIdentify.setBankAccount(request.getParameter("bankAccount"));
            userBankIdentify.setTrueName(request.getParameter("realname"));
            userBankIdentify.setIdNum(request.getParameter("idNum"));
            userBankIdentify.setTelephoneNum(request.getParameter("phoneNum"));
            userBankIdentify.setUserNum(userNum);
            userBankIdentify.setBankAccountIdentify(result);
            identify.identify(userBankIdentify);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("index.html");//返回首页
    }
}
