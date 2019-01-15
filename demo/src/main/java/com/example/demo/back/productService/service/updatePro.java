package com.example.demo.back.productService.service;

import com.example.demo.Dao.productHistroyMapper;
import com.example.demo.Dao.productMapper;
import com.example.demo.bean.Product;
import com.example.demo.bean.ProductHistroy;
import com.example.demo.util.nowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class updatePro {
    private com.example.demo.util.nowTime nowTime=new nowTime();
    @Autowired
    private productMapper productMapper;
    @Autowired
    private productHistroyMapper proHisMapper;

    public int update(Product product1){
        ProductHistroy productHistroy = new ProductHistroy();
        if(productMapper.selectProductByProductNum(product1.getProductNum())==null)return -1;
        productMapper.updateProduct(product1);
        productHistroy.setProductNum(product1.getProductNum());
        productHistroy.setProductName(product1.getProductName());
        productHistroy.setBankNum(product1.getBankNum());
        productHistroy.setCategory(product1.getCategory());
        productHistroy.setIntrate(product1.getIntrate());
        //productHistroy.setManagerNum(); manager.setManagerNum();调用登陆里面的一个接口得到managerNum
        productHistroy.setProductDescription(product1.getProductDescription());
        productHistroy.setAlterTime(nowTime.nowTime());
        proHisMapper.addProductHistroy(productHistroy);
        return 1;
    }
}
