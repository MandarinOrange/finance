package com.example.demo.order.controller;

import com.example.demo.bean.Audit;
import com.example.demo.bean.User;
import com.example.demo.order.service.impl.orderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/*
打印出所有的订单
 */

//@Controller
@RestController
public class showController extends HttpServlet {
    @Autowired
    orderServiceImpl orderService;

    @RequestMapping(value = "/order",method = RequestMethod.POST)//订单浏览的界面
    public List<Audit> doPost(HttpServletResponse response, HttpServletRequest request){
        HttpSession session=request.getSession();
        User user=new User();
        user=(User)session.getAttribute("user");
        long userNum = user.getUserNum();
        List<Audit> audits = orderService.selectAuditByUserNum(userNum);
        return audits;
    }
}
