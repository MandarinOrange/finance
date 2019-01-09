package com.example.demo.loginService;

import com.example.demo.bean.User;
import com.example.demo.loginService.API.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController extends HttpServlet {
    @Autowired
    private UserService userService;
    private User user;
    private String userPwd;

    @PostMapping("/Login.do")
    public void handle(HttpServletRequest request)throws Exception{
        String action=request.getParameter("action");
        if(action.equals("登录")){
            doPost1(request);
        }else{
            doPost3(request);
        }
    }
    public String  doPost3(HttpServletRequest request){
        String userName = request.getParameter("userName");
        userPwd = request.getParameter("userPwd");
        String userPwd1=request.getParameter("userPwd1");
        user=this.userService.selectUserByuserName("userName");
        if(user!=null){
            return "操作错误！";

        }else if(userPwd==userPwd1){
                long count = this.userService.count();
                this.userService.insertUser(count, userName, userPwd);
                return "插入成功！";
        }else{
               return "密码不一致！";
        }
    }

    public void doPost1(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        userPwd = request.getParameter("userPwd");
        user = this.userService.selectUserByuserName(userName);
    }

    @PostMapping("/Login1.do")
    public void doPost2(HttpServletRequest request) {
        String telephoneNum = request.getParameter("telephoneNum");
        userPwd = request.getParameter("userPwd");
        user = this.userService.selectUserBytelephoneNum(telephoneNum);
    }
    public String select(){
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