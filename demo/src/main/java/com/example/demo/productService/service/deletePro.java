package com.example.demo.productService.service;

import com.example.demo.Dao.productHistroyMapper;
import com.example.demo.bean.ProductHistroy;

//@Service
public class deletePro {
   // @Autowired
    private com.example.demo.productService.service.nowTime nowTime;
   // @Autowired
    private com.example.demo.Dao.productMapper productMapper;
   // @Autowired
    private productHistroyMapper proHisMapper;
    //@Autowired
    private ProductHistroy productHistroy;

    public int delete(int productNum){
        productMapper.deleteProduct(productNum);
        productHistroy.setProductNum(productNum);
        //productHistroy.setManagerNum(); manager.setManagerNum();调用登陆里面的一个接口得到managerNum
        productHistroy.setUpLoadTime(nowTime.nowTime());
        proHisMapper.addProductHistroy(productHistroy);
        return 1;
    }
}
