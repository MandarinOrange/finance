package com.example.demo.searchService.service;

import com.example.demo.bean.Product;

import java.util.List;

public interface ProductSearchService {
    //按关键字查询
    List<Product> findByNameLike(String productName);

    //按类别查询
    List<Product> findByCategory(String category);

    //按利率从高到低
    List<Product> findByIntrate(float intrate);

    ////默认按产品使用的产品的数量由高到低排序
    List<Product> findByCount();
}
