package com.example.demo.order.controller;

import com.example.demo.bean.Audit;
import com.example.demo.bean.User;
import com.example.demo.order.service.impl.orderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@RestController
public class orderController{
    @Autowired
    private orderServiceImpl orderService;

    @RequestMapping(value = "/orderlist",method = RequestMethod.POST)
    public List<Audit> orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user = new User();
        user = (User) session.getAttribute("user");
        long userNum = user.getUserNum();
        List<Audit> list = orderService.selectAuditByUserNum(userNum);
//        String json = JSONObject.toJSONString(list);
//        System.out.println(json);
//        response.getWriter().print(json);
        return list;
    }
}
