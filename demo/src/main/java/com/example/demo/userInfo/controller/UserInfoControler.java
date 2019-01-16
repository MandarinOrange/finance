package com.example.demo.userInfo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Product;
import com.example.demo.bean.User;
import com.example.demo.loginService.API.impl.UserService;
import com.example.demo.loginService.API.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@RestController
public class UserInfoControler {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public void UserInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        User user2 =userService.selectUserByuserName(user1.getUserName());
        String data = JSONObject.toJSONString(user2);
        response.getWriter().print(data);
        System.out.println(data);
    }

}
