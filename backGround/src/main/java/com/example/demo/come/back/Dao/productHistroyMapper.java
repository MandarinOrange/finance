package com.example.demo.come.back.Dao;



import com.example.demo.come.back.bean.ProductHistroy;
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

    @Insert("insert into producthistory(productNum, productName, category, " +
            "intrate, bankNum, productDescription, uploadTime, deleteTime, alterTime,managerNum)" +
            " values (#{productNum},#{productName},#{category},#{intrate},#{bankNum}," +
            "#{productDescription},#{upLoadTime},#{deleteTime},#{alterTime},#{managerNum})")
    public void addProductHistroy(ProductHistroy productHistroys);

//    @Update("update producthistroy set productNum=#{productNum},productName=#{productName}" +
//            ",category=#{category},intrate=#{intrate},bankNum=#{bankNum}," +
//            "productDescription=#{productDescription},uploadTime=#{uploadTime},deleteTime=#{deleteTime}," +
//            "alterTime=#{alterTime}where productNum=#{productNum}")
//    public void updateProductHistroy(ProductHistroy productHistroys);

//    @Delete("delete from producthistroy where productNum=#{productNum}")
//    public void deleteProductHistroy(long productNum);
}
