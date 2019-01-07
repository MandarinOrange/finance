package com.example.demo.Dao;

import com.example.demo.bean.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface productMapper {
    @Select("select * from product where productNum = #{productNum}")
    public Product selectProductByProductNum(String productNum);

    @Select("select intrate from product where productNum = #{productNum}")
    public Product selectProductIntrateByProductNum(String productNum);

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
    public void updateAudio(Product products);

    @Delete("delete from product where productNum=#{productNum}")
    public void deleteAudio(String productNum);
}
