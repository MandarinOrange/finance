package com.example.demo.register.controller;

import com.example.demo.register.phone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class phoRegController {

    phone phone=new phone();

    @RequestMapping("/phoreg")//第一个手机验证界面
    public String doPost(HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer=null;
        try{
            int num=Integer.parseInt(request.getParameter("phoneNum"));
            response.setContentType("text/hmtl;charset=utf-8");
            writer=response.getWriter();
            if(phone.phoneRegister(num)==1){
                return "";//跳转到bankCardManager界面
            }else{
                writer.write("验证失败");
                return "";//跳转到第一个手机验证界面
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return "页面出错";
    }
}
