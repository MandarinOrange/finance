package com.example.demo.loginService;

import com.example.demo.bean.User;
import com.example.demo.loginService.API.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController extends HttpServlet{
    @Autowired
    private UserService userService;
    @PostMapping("/Login.do")
    public String doPost1(HttpServletRequest request, HttpServletResponse response){
        String userName=request.getParameter("userName");
        String userPwd=request.getParameter("userPwd");
        User user=this.userService.selectUserByuserName(userName);
        if(user!=null){
            if(user.getUserPwd().equals(userPwd)){
                return "/login1";
            }
            else{
                return "/login2";
            }
        }else{
            return "/login2";
        }
    }
}
