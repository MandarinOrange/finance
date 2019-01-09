package com.example.demo.productService.tools;

import com.example.demo.Dao.productHistroyMapper;
import com.example.demo.Dao.productMapper;
import com.example.demo.bean.Product;
import com.example.demo.bean.ProductHistroy;
import org.springframework.beans.factory.annotation.Autowired;

public class addPro {

      private nowTime nowTime=new nowTime();
      @Autowired
      private productMapper productMapper;
      @Autowired
      private productHistroyMapper proHisMapper;
      @Autowired
      private ProductHistroy productHistroy;

      public int add(Product product1){
            productMapper.addProduct(product1);
            productHistroy.setProductNum(product1.getProductNum());
            productHistroy.setProductName(product1.getProductName());
            productHistroy.setBankNum(product1.getBankNum());
            productHistroy.setCategory(product1.getCategory());
            productHistroy.setIntrate(product1.getIntrate());
            //productHistroy.setManagerNum(); manager.setManagerNum();调用登陆里面的一个接口得到managerNum
            productHistroy.setProductDescription(product1.getProductDescription());
            productHistroy.setUpLoadTime(nowTime.nowTime());
            proHisMapper.addProductHistroy(productHistroy);
            return 1;
      }
}
