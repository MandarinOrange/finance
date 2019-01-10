package com.example.demo.register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class pwdController extends HttpServlet {

    @RequestMapping("/")//再一次确认密码界面
    public String doPost(HttpServletResponse response, HttpServletRequest request){
        //int
        return "";
    }

}
