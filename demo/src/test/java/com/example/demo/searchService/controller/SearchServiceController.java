package com.example.demo.searchService.controller;

import com.example.demo.bean.Product;
import com.example.demo.searchService.service.impl.ProductSearchServiceImpl;
import org.junit.runner.Request;

import java.util.List;


public class SearchServiceController {
    ProductSearchServiceImpl productSearchService = new ProductSearchServiceImpl();
    //模糊查询
    @GetMapping("/findByNameLike/{productName}")
    public List<Product> findByNameLike(@PathVariable(value = "productName") String productName){
        return productSearchService.findByNameLike(productName);
    }
}
