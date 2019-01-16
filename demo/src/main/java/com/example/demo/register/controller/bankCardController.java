package com.example.demo.register.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.Dao.userMapper;
import com.example.demo.bean.User;
import com.example.demo.bean.UserBankIdentify;
import com.example.demo.register.identify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class bankCardController extends HttpServlet {

    @Autowired
    private identify identify;
    @Autowired
    private userMapper userMapper;

    @RequestMapping("/binding")//卡号绑定界面
    public void doPost(HttpServletResponse response, HttpServletRequest request)throws IOException {
        HttpSession session=request.getSession();
        User user=new User();
        user=(User)session.getAttribute("user");
        try{
            long num=user.getUserNum();
            short result=0;
            UserBankIdentify userBankIdentify=new UserBankIdentify();
            userBankIdentify.setBankAccount(request.getParameter("bankAccount"));
            userBankIdentify.setTrueName(request.getParameter("realname"));
            userBankIdentify.setIdNum(request.getParameter("idNum"));
            userBankIdentify.setTelephoneNum(request.getParameter("phoneNum"));
            userBankIdentify.setUserNum(num);
            userBankIdentify.setBankAccountIdentify(result);
            identify.identify(userBankIdentify);
            userMapper.updateIsId(user.getUserNum());
        }catch (Exception e){
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("value","认证成功");
        String json = JSONObject.toJSONString(map);
        response.getWriter().print(json);
        //response.sendRedirect("index.html");//返回首页
    }
}
