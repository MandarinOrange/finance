package com.example.demo.come.back.productService.controller;


import com.example.demo.come.back.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class updateController extends HttpServlet {
   @Autowired
   com.example.demo.come.back.productService.service.updatePro updatePro;
    @RequestMapping("/updateproduct")
    public String doPost(HttpServletResponse response, HttpServletRequest request){
        PrintWriter writer=null;
        Product product=new Product();
        try{
            product.setProductNum(Long.parseLong(request.getParameter("productNum")));
            product.setProductName(request.getParameter("productName"));
            product.setBankNum(Integer.parseInt(request.getParameter("bankNum")));
            product.setCategory(request.getParameter("productName"));
            product.setIntrate(Float.parseFloat(request.getParameter("intrate")));
            product.setProductDescription(request.getParameter("description"));
            product.setPictureAddress(request.getParameter("address"));
            int result= updatePro.update(product);
            response.setContentType("text/hmtl;charset=utf-8");
            writer=response.getWriter();
            if(result==1){
                writer.write("修改成功");
                return "/";//返回增加删除修改的总页面
            }else if(result==-1){
                writer.write("此业务不存在 ");
                return "/";
            }
            writer.write("修改失败");
            return "/";//返回修改的页面
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                writer.close();
            }
        }
        return  "页面出错";
    }

}
