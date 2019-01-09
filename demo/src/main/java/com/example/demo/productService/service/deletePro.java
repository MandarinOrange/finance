package com.example.demo.productService.service;

import com.example.demo.Dao.productHistroyMapper;
import com.example.demo.Dao.productMapper;
import com.example.demo.bean.Product;
import com.example.demo.bean.ProductHistroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class deletePro {
    private nowTime nowTime = new nowTime();
    @Autowired
    private productMapper productMapper;
    @Autowired
    private productHistroyMapper proHisMapper;


    public int delete(long productNum){
        ProductHistroy productHistroy = new ProductHistroy();

        Product product = productMapper.selectProductByProductNum(productNum);
        if(product == null)return -1;
        productHistroy.setProductNum(product.getProductNum());
        productHistroy.setProductName(product.getProductName());
        productHistroy.setBankNum(product.getBankNum());
        productHistroy.setCategory(product.getCategory());
        productHistroy.setIntrate(product.getIntrate());
        productHistroy.setProductDescription(product.getProductDescription());

        productMapper.deleteProduct(productNum);
        //productHistroy.setManagerNum(); manager.setManagerNum();调用登陆里面的一个接口得到managerNum
        productHistroy.setDeleteTime(nowTime.nowTime());
        proHisMapper.addProductHistroy(productHistroy);
        return 1;
    }
}
