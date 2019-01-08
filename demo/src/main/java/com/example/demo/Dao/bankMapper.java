package com.example.demo.Dao;

import com.example.demo.bean.Bank;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface bankMapper {

    @Select("select * from bank where bankNum = #{bankNum}")
    public Bank selectBankByBankNum(int bankNum);

    @Select("select * from bank where bankName = #{bankName}")
    public Bank selectBankByBankName(String bankName);

    @Select("select * from bank")
    public List<Bank> select();

    @Insert("insert into bank(bankNum, bankName, contact, " +
            " values (#{bankNum},#{bankName},#{contact},)")
    public void addBank(Bank banks);

    @Update("update bank set bankNum=#{bankNum},bankName=#{bankName}" +
            ",contact=#{contact} where bankNum=#{bankNum}")
    public void updateBank(Bank banks);

//    @Delete("delete from bank where bankNum=#{bankNum}")
//    public void deleteBank(String bankNum);
//
//    @Delete("delete from bank where bankName=#{bankName}")
//    public void deleteBanks(String bankName);
}
