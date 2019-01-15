package com.example.demo.register.controller;

import com.example.demo.register.phone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class phoRegController2 {

    phone phone=new phone();

    @RequestMapping("/phoreg2")//第二个手机验证界面
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        PrintWriter writer=null;
        try{
            int num=Integer.parseInt(request.getParameter("phoneNum"));
            response.setContentType("text/hmtl;charset=utf-8");
            writer=response.getWriter();
            if(phone.phoneRegister(num)==1){
                response.sendRedirect("loanInformation.html");//跳转到Loan界面
            }else{
                writer.write("验证失败");
                response.sendRedirect("checkPhoneNum2.html");//跳转到第二个手机验证界面
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        response.sendRedirect("");
    }
}
