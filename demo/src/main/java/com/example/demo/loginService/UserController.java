package com.example.demo.loginService;

import com.example.demo.bean.User;
import com.example.demo.loginService.API.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class UserController extends HttpServlet {
    @Autowired
    private UserService userService;

    //private User user = new User();
   // private String userPwd;

    @PostMapping("/login")
    public void handle(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String action=request.getParameter("action");
        if(action.equals("登录")){
            doPost1(request,response);
        }else{
            doPost3(request,response);
        }
    }

    public String  doPost3(HttpServletRequest request,HttpServletResponse response){
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userPwd1=request.getParameter("userPwd1");
        User user=this.userService.selectUserByuserName("userName");
        if(user!=null){
            return "/operateError";
        }
        if(userPwd.equals(userPwd1)){
                long count = this.userService.count()+1;
                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
                String registerTime=dateFormat.format(new Date());
                String userRight="0";
                this.userService.insertUser(count, userName, userPwd,registerTime,userRight);
                return "/registerSuccess";
        }else{
               return "/userPwdNotSame";
        }
    }

    public String  doPost1(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        User user = this.userService.selectUserByuserName(userName);
        if(user!=null){
            if(user.getUserPwd().equals(userPwd)){
                HttpSession session=request.getSession();
                session.setAttribute("user",user);
                //request.getRequestDispatcher("../首页/index.html").forward(request,response);
                //return "redirect:http://localhost:8080/firstproject/demo/Front-end/首页/index.html";
                return "/success";
            }
            else{
                //response.sendRedirect("../userPwdError");
                return "userPwdError";
            }
        }else{
            //response.sendRedirect("../userNotExist");
            return "/userNotExit";
        }
    }

   /** @PostMapping("/Login1.do")
    public void doPost2(HttpServletRequest request) {
        String telephoneNum = request.getParameter("telephoneNum");
        userPwd = request.getParameter("userPwd");
        user = this.userService.selectUserBytelephoneNum(telephoneNum);
    }
    public String select(Object user){
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
}**/
}