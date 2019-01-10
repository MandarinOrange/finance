package com.example.demo.loginService;

import com.example.demo.bean.User;
import com.example.demo.loginService.API.impl.UserServiceImpl;
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
    private UserServiceImpl userServiceImpl;

    @PostMapping("/login")
    public String  handle(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        User user = this.userServiceImpl.selectUserByuserName(userName);
        if(user!=null){
            if(user.getUserPwd().equals(userPwd)){
                HttpSession session=request.getSession();
                session.setAttribute("user",user);
                return "redirect:index.html";
                //request.getRequestDispatcher("/").forward(request,response);
            }
            else{
                return "/userPwdError";
                //response.sendRedirect("userPwdError.jsp");
            }
        }else{
            return "userNotExist";
            //response.sendRedirect("notexit.jsp");
        }
    }
    @PostMapping("/login1")
    public String  handle1(HttpServletRequest request,HttpServletResponse response){
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userPwd1=request.getParameter("userPwd1");
        User user=this.userServiceImpl.selectUserByuserName("userName");
        long count = 0;
        if(user!=null){
            return "/operateError";
        }else if(userPwd.equals(userPwd1)){
                count = this.userServiceImpl.count()+1;
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
                String registerTime=dateFormat.format(new Date());
                String userRight="0";
                user = new User();
                user.setUserNum(count);
                user.setUserName(userName);
                user.setUserPwd(userPwd);
                user.setRegisterTime(registerTime);
                user.setUserRight(userRight);
                this.userServiceImpl.insertUser(user);
                return "/registerSuccess";
        }else{
               return "/userPwdNotSame";
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