package com.example.demo.come.back.Dao;


import com.example.demo.come.back.bean.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface productMapper {
    @Select("select * from product where productName like CONCAT('%',#{0},'%')")
    public List<Product> findByNameLike(String productName);

    @Select("select * from product where productName = #{category}")
    public List<Product> findByCategory(String category);


    @Select("select * from product where intrate = #{intrate} order by intrate ASC")
    public List<Product> findByIntrate(float intrate);

    @Select("select * from product where productNum = #{productNum}")
    public Product selectProductByProductNum(long productNum);

    @Select("select * from product where productName = #{productName}")
    public Product selectProductByProductName(String productName);

    @Select("select * from product")
    public List<Product> select();

    @Insert("insert into product(productNum, productName, category, intrate, " +
            "bankNum, productDescription, pictureAddress)" +
            " values (#{productNum},#{productName},#{category},#{intrate},#{bankNum}," +
            "#{productDescription},#{pictureAddress})")
    public void addProduct(Product products);

    @Update("update product set productNum=#{productNum},productName=#{productName}" +
            ",category=#{category},intrate=#{intrate},bankNum=#{bankNum}," +
            "productDescription=#{productDescription},pictureAddress=#{pictureAddress}")
    public void updateProduct(Product products);


    @Delete("delete from product where productNum=#{productNum}")
    public void deleteProduct(long productNum);
}
