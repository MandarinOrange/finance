package com.example.demo.userCenter.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.User;
import com.example.demo.loginService.API.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class personInforController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/ix",method = RequestMethod.POST)//个人详情页面
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user= (User)session.getAttribute("user");
        User user2 =userService.selectUserByuserName(user.getUserName());
        String data = JSONObject.toJSONString(user2);
        response.getWriter().print(data);
    }
}
