package com.example.demo.register.controller;

import com.example.demo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class pwdController2 extends HttpServlet {
    @RequestMapping("/pwd2")//再一次确认密码界面
    public void doPost(HttpServletResponse response, HttpServletRequest request)throws IOException {
        HttpSession session=request.getSession();
        User user=new User();
        user=(User)session.getAttribute("user");
        String pwd=request.getParameter("userPwd");
        if(user.getUserPwd().equals(pwd)){
            response.sendRedirect("loanInformation.html");//贷款的界面
        }else{
            response.sendRedirect("Untitled-1.html");//登陆失败
        }
    }

}
