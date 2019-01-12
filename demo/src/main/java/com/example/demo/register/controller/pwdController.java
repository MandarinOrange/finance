package com.example.demo.register.controller;

import com.example.demo.Dao.userMapper;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class pwdController extends HttpServlet {
    @Autowired
    userMapper userMapper;

    @RequestMapping("/")//再一次确认密码界面
    public String doPost(HttpServletResponse response, HttpServletRequest request){
        HttpSession session=request.getSession();
        User user=new User();
        user=(User)session.getAttribute("user");
        String pwd=request.getParameter("userPwd");
        if(userMapper.selectPwd(user.getUserNum(),pwd)==1){
            return "";//银行卡验证的界面
        }else{
            return "";//登陆失败
        }
    }

}
