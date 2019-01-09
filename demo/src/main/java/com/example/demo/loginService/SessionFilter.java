package com.example.demo.loginService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
public class SessionFilter implements Filter {
    String NO_LOGIN="/notLogin";
    String includeUrl=new String("redirect:http://localhost:8080/firstproject/demo/Front-end/Login/Login.html");
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException,IOException{
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpSession session=request.getSession(false);
        String uri=request.getRequestURI();
        //是否需要过滤
        boolean needFilter=isNeedFilter(uri);
        if(!needFilter){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //需要过滤器
            //session中包含user对象，则是登录状态
            if(session!=null&&session.getAttribute("user")!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                String requestType=request.getHeader("X-Requested-with");
                //判断是否是ajax请求
                if(requestType!=null&&"XMLHttpRequest".equals(requestType)){
                    response.sendRedirect(NO_LOGIN);
                }else{
                    //重定向到登录页(需要在static文件夹下建立此html文件)
                    response.sendRedirect(request.getContextPath()+includeUrl);
                }
                return;
            }
        }


    }
    public boolean isNeedFilter(String uri){
          if(includeUrl.equals(uri)){
              return false;
          }
      return true;
    }


}
