package com.example.demo.productService.tools;

import com.example.demo.Dao.productHistroyMapper;
import com.example.demo.bean.Product;
import com.example.demo.bean.ProductHistroy;

public class deletePro {
    private com.example.demo.productService.tools.nowTime nowTime;
    private com.example.demo.Dao.productMapper productMapper;
    private productHistroyMapper proHisMapper;
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
