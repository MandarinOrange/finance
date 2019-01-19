package com.example.demo.circulator.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.User;
import com.example.demo.circulator.service.PayCirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PayCirController {
    @Autowired
    PayCirService payCirService;

    @PostMapping("/pay")
    public void payAmountCir(HttpServletRequest request, HttpServletResponse response)throws IOException {
        long checkNum = Long.parseLong(request.getParameter("checkNum"));
        double pay = Double.parseDouble(request.getParameter("amount"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        long userNum = user.getUserNum();
        int result = payCirService.payAmountCirculator(checkNum,userNum,pay);
        Map map = new HashMap();
        map.put("value",result);
        if(result==1){
            String json = JSONObject.toJSONString(map);
            response.getWriter().print(json);
        }else if(result==-2){
//            return;
        }else if(result==-3){
//            return;
        }
    }
}
