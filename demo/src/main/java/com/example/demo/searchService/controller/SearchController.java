package com.example.demo.searchService.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Product;
import com.example.demo.searchService.service.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private ProductSearchService productSearchService;

    //按关键字搜索
    @RequestMapping(value = "/key",method = RequestMethod.POST)
    public List<Product> searchByKey(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Product> list = new ArrayList<Product>();
        String productName = request.getParameter("productName");
        list = productSearchService.findByNameLike(productName);
//        String data = JSONObject.toJSONString(list);
//        response.getWriter().print(data);
        System.out.println(list);
        return list;
    }

    //按产品类别搜索
    @RequestMapping(value = "/category",method = RequestMethod.POST)
    public List<Product> searchByCategory(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Product> list = new ArrayList<Product>();
        String category = request.getParameter("category");
        list = productSearchService.findByCategory(category);
        return list;
    }

    //按利率排序由低到高
    @RequestMapping(value = "/intrate",method = RequestMethod.POST)
    public List<Product> searchByIntrate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Product> list = new ArrayList<Product>();
        Float intrate = Float.parseFloat(request.getParameter("intrate"));
        list = productSearchService.findByIntrate(intrate);
        return list;
    }

    //按产品使用的产品的数量由高到低排序
    @RequestMapping(value = "/count",method = RequestMethod.POST)
    public List<Product> searchByCount(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Product> list = new ArrayList<Product>();
        list = productSearchService.findByCount();
//        String data = JSONObject.toJSONString(list);
//        response.getWriter().print(data);
        return list;
    }
}
