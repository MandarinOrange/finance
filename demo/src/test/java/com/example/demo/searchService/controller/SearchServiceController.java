package com.example.demo.searchService.controller;


import com.example.demo.bean.Product;
import com.example.demo.searchService.service.ProductSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchServiceController {
    private ProductSearchService productSearchService;
    @RequestMapping("/search")
    public List<Product> productSearch(HttpServletRequest request, HttpServletResponse response){
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
        return list;
    }
}
