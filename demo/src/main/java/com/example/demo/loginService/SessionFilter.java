package com.example.demo.loginService;

import com.example.demo.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
public class SessionFilter implements Filter {
    String NO_LOGIN="/Login.html";
    String[] includeUrls=new String[]{"/Login.html","/Register.html","/login","/register","/userExisted.html","/userPwdError.html","/userNotExist.html","/userPwdNotSame.html",
            "/wechat","/access","/wechat/access"};
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException,IOException{
//        HttpServletRequest request=(HttpServletRequest) servletRequest;
//        HttpServletResponse response=(HttpServletResponse) servletResponse;
//        HttpSession session=request.getSession();
//        String uri=request.getRequestURI();
//        System.out.println(uri);
//        //是否需要过滤
//        boolean needFilter=isNeedFilter(uri);
//        if(!needFilter){
//            //filterChain.doFilter(servletRequest,servletResponse);
//            filterChain.doFilter(request,response);
//        }else{
//            //需要过滤器
//            //session中包含user对象，则是登录状态
//            User user = (User)session.getAttribute("user");
//            if(session!=null&&session.getAttribute("user")!=null){
//                filterChain.doFilter(servletRequest,servletResponse);
//            }else{
//                String requestType=request.getHeader("X-Requested-with");
//                //判断是否是ajax请求
//                if(requestType!=null&&"XMLHttpRequest".equals(requestType)){
//                    response.sendRedirect(NO_LOGIN);
//                }else{
//                    //重定向到登录页(需要在static文件夹下建立此html文件)
//                    response.sendRedirect("/Login.html");
//                }
//            }
//        }
//    }
//
//    public boolean isNeedFilter(String uri) {
//        for (String includeUrl : includeUrls) {
//            if (includeUrl.equals(uri)) {
//                return false;
//            }
//        }
//      return true;
//    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        System.out.println(path);

        // 从session里用户
        User user = (User)session.getAttribute("user");

        //创建类Constants.java，里面写的是无需过滤的页面
        for (int i = 0; i < includeUrls.length; i++) {

            if (path.indexOf(includeUrls[i]) > -1) {
                chain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        // 登陆页面无需过滤
//        if(path.indexOf("/Login,html") > -1) {
//            chain.doFilter(servletRequest, servletResponse);
//            return;
//        }
//

        // 判断如果没有取到用户信息,就跳转到登陆页面
        if (user == null) {
            // 跳转到登陆页面
            servletResponse.sendRedirect("/Login.html");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
