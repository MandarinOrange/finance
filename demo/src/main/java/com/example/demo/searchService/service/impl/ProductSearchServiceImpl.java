package com.example.demo.searchService.service.impl;

import com.example.demo.Dao.productMapper;
import com.example.demo.Dao.usageDateMapper;
import com.example.demo.bean.Product;
import com.example.demo.searchService.service.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchServiceImpl implements ProductSearchService {
    @Autowired
    productMapper productMapper;
    usageDateMapper usageDateMapper;
    Product product;

    @Override
    public List<Product> findByNameLike(String productName){
        return productMapper.findByNameLike(productName);
    }

    @Override
    public List<Product> findByCategory(String category){
        return productMapper.findByCategory(category);
    }

    @Override
    public List<Product> findByIntrate(float intrate){
        return productMapper.findByIntrate(intrate);
    }

    @Override
    public List<Product> findByCount(){
        List<Product> productList = new ArrayList<Product>();
        List<Integer> listusage = usageDateMapper.selectByCount();
        int[] arr = listusage.stream().mapToInt(Integer::valueOf).toArray();
        for(int i=0;i<arr.length;i++){
            product = productMapper.selectProductByProductNum(arr[i]);
            productList.add(product);
        }
        return productList;
    }

}
