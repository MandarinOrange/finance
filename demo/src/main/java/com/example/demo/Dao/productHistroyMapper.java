package com.example.demo.Dao;


import com.example.demo.bean.ProductHistroy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface productHistroyMapper {
    @Select("select * from producthistroy where productNum = #{productNum}")
    public ProductHistroy selectAudioByCheckNum(long productNum);

    @Select("select * from producthistroy")
    public List<ProductHistroy> select();

    @Insert("insert into productHistroy(productNum, productName, category, " +
            "intrate, bankNum, productDescription, uploadTime, deleteTime, alterTime)" +
            " values (#{productNum},#{productName},#{category},#{intrate},#{bankNum}," +
            "#{productDescription},#{uploadTime},#{deleteTime},#{alterTime})")
    public void addProductHistroy(ProductHistroy productHistroys);

//    @Update("update producthistroy set productNum=#{productNum},productName=#{productName}" +
//            ",category=#{category},intrate=#{intrate},bankNum=#{bankNum}," +
//            "productDescription=#{productDescription},uploadTime=#{uploadTime},deleteTime=#{deleteTime}," +
//            "alterTime=#{alterTime}where productNum=#{productNum}")
//    public void updateProductHistroy(ProductHistroy productHistroys);

//    @Delete("delete from producthistroy where productNum=#{productNum}")
//    public void deleteProductHistroy(int productNum);
}
