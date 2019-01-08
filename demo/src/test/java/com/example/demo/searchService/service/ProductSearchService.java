package com.example.demo.searchService.service;

import com.example.demo.bean.Product;

import java.util.List;

public interface ProductSearchService {
    List<Product> findByNameLike(String productName);

    List<Product> findByCategory(String category);

    List<Product> findByIntrate(float intrate);

    List<Product> findByCount();
}
