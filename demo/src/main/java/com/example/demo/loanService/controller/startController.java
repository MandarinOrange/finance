package com.example.demo.loanService.controller;


import com.example.demo.Dao.userMapper;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class startController extends HttpServlet {
    @Autowired
    private userMapper userMapper;

    @RequestMapping("/start")//浏览商品之后点击申请贷款的按钮之后跳到的界面
    public String doPost(HttpServletResponse response, HttpServletRequest request){
        User user=new User();
        int num=1;//从登陆那里得到登陆者的序号
        user=userMapper.selectUserByuserNum(num);
        if(user.getIsIdentify()=="1"){
            return "";//验证手机号的界面二号
        }if(user.getIsIdentify()=="0"){
            return "";//认证的界面
        }else{
            return "";//页面出错的界面
        }
    }
}
