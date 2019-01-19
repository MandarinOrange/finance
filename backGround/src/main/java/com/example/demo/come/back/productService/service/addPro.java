package com.example.demo.come.back.productService.service;


import com.example.demo.come.back.Dao.productHistroyMapper;
import com.example.demo.come.back.Dao.productMapper;
import com.example.demo.come.back.bean.Product;
import com.example.demo.come.back.bean.ProductHistroy;
import com.example.demo.come.back.util.nowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addPro {
      private com.example.demo.come.back.util.nowTime nowTime=new nowTime();
      @Autowired
      private com.example.demo.come.back.Dao.productMapper productMapper;
      @Autowired
      private productHistroyMapper proHisMapper;

      public int add(Product product1){
            ProductHistroy productHistroy = new ProductHistroy();
            if(productMapper.selectProductByProductNum(product1.getProductNum())!=null)return -1;
            productMapper.addProduct(product1);
            productHistroy.setProductNum(product1.getProductNum());
            productHistroy.setProductName(product1.getProductName());
            productHistroy.setBankNum(product1.getBankNum());
            productHistroy.setCategory(product1.getCategory());
            productHistroy.setIntrate(product1.getIntrate());
            //productHistroy.setManagerNum(); manager.setManagerNum();调用登陆里面的一个接口得到managerNum
            productHistroy.setProductDescription(product1.getProductDescription());
            productHistroy.setUpLoadTime(nowTime.nowTime());
            //System.out.println(productHistroy.getUpLoadTime()+productHistroy.getBankNum());
            proHisMapper.addProductHistroy(productHistroy);
            return 1;
      }
}
