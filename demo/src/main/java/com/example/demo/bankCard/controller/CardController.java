package com.example.demo.bankCard.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bankCard.service.BankCardService;
import com.example.demo.bean.User;
import com.example.demo.bean.UserBankIdentify;
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
public class CardController {
    @Autowired
    private BankCardService bankCardService;

    @RequestMapping(value = "/card",method = RequestMethod.POST)
    public List<UserBankIdentify> UserInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<UserBankIdentify> list = new ArrayList<UserBankIdentify>();
        list = bankCardService.selectUserBankByUserNum(user.getUserNum());
        return list;
//        String data = JSONObject.toJSONString();
//        response.getWriter().print(data);
        //System.out.println(data);
    }
}
