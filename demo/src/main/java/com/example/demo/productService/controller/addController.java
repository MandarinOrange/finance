package com.example.demo.productService.controller;

import com.example.demo.bean.Product;
import com.example.demo.productService.tools.addPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class addController extends HttpServlet {
    @Autowired
    private addPro addPro;
    @RequestMapping("/addproduct")
    public String doPost(HttpServletResponse response,HttpServletRequest request){
        Product product=new Product();
        PrintWriter writer=null;
        try{
            product.setProductNum(Integer.parseInt(request.getParameter("productNum")));
            product.setProductName(request.getParameter("productName"));
            product.setBankNum(Integer.parseInt(request.getParameter("bankNum")));
            product.setCategory(request.getParameter("productName"));
            product.setIntrate(Integer.parseInt(request.getParameter("intrate")));
            product.setProductDescription(request.getParameter("description"));
            product.setPictureAddress(request.getParameter("address"));
            int result= addPro.add(product);
            response.setContentType("text/hmtl;charset=utf-8");
            writer=response.getWriter();
            if(result==1){
                writer.write("增加成功");
                return "/";//返回增加删除修改的总页面
            }
            writer.write("增加失败");
            return "/";//返回增加的页面
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
