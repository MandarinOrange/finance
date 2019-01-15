package com.example.demo.order.controller;

import com.example.demo.bean.Audit;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class unCompController {
    @Autowired
    com.example.demo.Dao.auditMapper auditMapper;

    @RequestMapping(value="/unfinished",method = RequestMethod.POST)//已经完成的订单浏览的界面
    public List<Audit> doPost(HttpServletResponse response, HttpServletRequest request){
        HttpSession session=request.getSession();
        User user=new User();
        user=(User)session.getAttribute("user");
        return auditMapper.selectByNumUnfinshed(user.getUserNum());
    }
}
