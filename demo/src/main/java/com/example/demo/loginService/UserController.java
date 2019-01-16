package com.example.demo.loginService;

import com.example.demo.Dao.managerMapper;
import com.example.demo.Dao.userMapper;
import com.example.demo.bean.User;
import com.example.demo.loginService.API.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private userMapper userMapper;
    @Autowired
    private managerMapper managerMapper;

    @PostMapping("/login")
    //@ResponseBody
    public void  handle( HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        //System.out.println("_______________");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        long usernum = this.userServiceImpl.selectUserByuserName(userName);
        int result = 0;
        if(usernum==1){
            if(userMapper.selectPwd(usernum,userPwd)==1){
                HttpSession session=request.getSession();
                session.setAttribute("user",usernum);
                result = 1;
            } else{
                result = 2;
            }
        }else{
            result = 3;
        }
        if(result==1)response.sendRedirect("index.html");
        else if(result==2)response.sendRedirect("userPwdError.html");
        else response.sendRedirect("userNotExist.html");
    }


    @PostMapping("/register")
    public void  handle1(HttpServletRequest request,HttpServletResponse response)throws IOException{
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userPwd1=request.getParameter("userPwd1");
        long usernum = this.userServiceImpl.selectUserByuserName(userName);
        User user=new User();
        long count = 0;
        int result = 0;
        if(usernum!=1){
            result = 2;
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
                //System.out.println(user);
                this.userServiceImpl.insertUser(user);
                result = 1;
        }else{
               result = 3;
        }
        if(result==1)response.sendRedirect("RegisterSuccess.html");
        else if(result==2)response.sendRedirect("userExisted.html");
        else response.sendRedirect("userPwdNotSame.html");
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
   @RequestMapping("")//管理员登陆的界面
    public String doPost3(HttpServletRequest request,HttpServletResponse response){
       String managerName = request.getParameter("managerName");
       String managerPwd = request.getParameter("managerPwd");
       long managerNum = managerMapper.selectManagerByManagerName(managerName);
       int result = 0;
       if(managerNum!=1){
           if(managerMapper.selectPwd(managerNum,managerPwd)==1){
               HttpSession session=request.getSession();
               session.setAttribute("managerNum",managerNum);
               return "";
           } else{
               return "密码不存在";
           }
       }else{
           return "用户不存在";
       }
   }
}