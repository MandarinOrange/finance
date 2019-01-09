package com.example.demo.productService.controller;


import com.example.demo.bean.Product;
import com.example.demo.productService.service.deletePro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class deleteController extends HttpServlet {
    @Autowired
    deletePro deletes;
    @RequestMapping("/deleteproduct")
    public String doPost(HttpServletResponse response, HttpServletRequest request){
        PrintWriter writer=null;
        Product product = new Product();
        try{
            long productNum=Long.parseLong(request.getParameter("productNum"));
            int result= deletes.delete(productNum);
            response.setContentType("text/hmtl;charset=utf-8");
            writer=response.getWriter();
            if(result==1){
                writer.write("删除成功");
                return "/";//返回增加删除修改的总页面
            }
            writer.write("删除失败");
            return "/";//返回删除的页面
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
