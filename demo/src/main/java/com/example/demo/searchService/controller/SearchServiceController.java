package com.example.demo.searchService.controller;


import com.example.demo.bean.Product;
import com.example.demo.searchService.service.ProductSearchService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchServiceController extends HttpServlet {
    @Autowired
    private ProductSearchService productSearchService;

    @RequestMapping("/search")
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Product> list = new ArrayList<Product>();
        String productName = request.getParameter("productName");
        String category = request.getParameter("category");
        float intrate = Integer.parseInt(request.getParameter("intrate"));
        if(productName!=null){
            list = productSearchService.findByNameLike(productName);

            //按关键字搜索
        }else if(category!=null){
            list = productSearchService.findByCategory(category);
            //按产品类别搜索
        }else if(intrate!=0){
            list = productSearchService.findByIntrate(intrate);
            //按利率排序由低到高
        }else{
            list = productSearchService.findByCount();
            //默认按产品使用的产品的数量由高到低排序
        }
        String json = JSONObject.toJSONString(list);
        response.getWriter().print(json);

    }

    @PostMapping("/showIndex")
    public void showPro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        List<Product> products = productSearchService.findByCount();
        String json = JSONObject.toJSONString(products);
        System.out.println(json);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(json);
    }
}
