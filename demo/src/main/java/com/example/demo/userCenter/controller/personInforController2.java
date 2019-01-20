package com.example.demo.userCenter.controller;

import com.example.demo.Dao.userMapper;
import com.example.demo.bean.User;
import com.example.demo.loginService.API.impl.UserService;
import com.example.demo.userCenter.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class personInforController2 {
    @Autowired
    userMapper userMapper;
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/iy")
    public String doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        HttpSession session=request.getSession();
        User user=new User();
        user=(User)session.getAttribute("user");
        user.setUserName(request.getParameter("userName"));
        user.setTelephoneNum(request.getParameter("phoneNum"));
        user.setAddress(request.getParameter("address"));
        userInfoService.updateUser(user);
        return "";
    }
}
