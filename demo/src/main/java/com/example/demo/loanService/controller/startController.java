package com.example.demo.loanService.controller;


import com.example.demo.Dao.userMapper;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class startController extends HttpServlet {
    @Autowired
    private userMapper userMapper;

    @RequestMapping("/start")//浏览商品之后点击申请贷款的按钮之后跳到的界面
    public void doPost(HttpServletResponse response, HttpServletRequest request)throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=new User();
        user=(User)session.getAttribute("user");
        short num=userMapper.selectIsId(user.getUserNum());
        if(num==1){
            response.sendRedirect("checkPhoneNum2.html");
            return;
        }else if(num==0){
            response.sendRedirect("checkPhoneNum.html");//认证的界面
            return;
        }else{
            response.sendRedirect("Untitled-1.html");//页面出错的界面
            return;
        }
    }
}
