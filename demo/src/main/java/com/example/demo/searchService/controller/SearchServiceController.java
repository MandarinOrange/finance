package com.example.demo.searchService.controller;


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

//@Controller
@RestController
@RequestMapping("/")
public class SearchServiceController{
    @Autowired
    private ProductSearchService productSearchService;

    @RequestMapping(value = "/search/show",method = RequestMethod.POST)
    public List<Product> search(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Product> list = new ArrayList<Product>();
        String productName = request.getParameter("productName");
        String category = request.getParameter("category");
        //float intrate = Float.parseFloat(request.getParameter("intrate"));
        if(productName!=null){
            list = productSearchService.findByNameLike(productName);

            //按关键字搜索
        }else if(category!=null){
            list = productSearchService.findByCategory(category);
            //按产品类别搜索
//        }else if(intrate!=0){
//            list = productSearchService.findByIntrate(intrate);
//            //按利率排序由低到高
        }else{
            list = productSearchService.findByCount();
            //默认按产品使用的产品的数量由高到低排序
        }
        return list;
    }

    @RequestMapping(value = "/showIndex",method = RequestMethod.POST)
    public List<Product> showPro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        List<Product> products = productSearchService.findByCount();
        response.setCharacterEncoding("utf-8");
        System.out.println(products);
        return products;
        //String json = JSONObject.toJSONString(list);
        //response.getWriter().print(json);
    }
}
