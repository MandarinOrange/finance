package com.example.demo.Dao;

import com.example.demo.bean.bank;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface bankMapper {

    @Select("select * from bank where bankNum = #{bankNum}")
    public bank selectBankByBankNum(int bankNum);

    @Select("select * from bank where bankName = #{bankName}")
    public bank selectBankByBankName(int bankName);

    @Select("select * from bank")
    public List<bank> select();

    @Insert("insert into bank(bankNum, bankName, contact, " +
            " values (#{bankNum},#{bankName},#{contact},)")
    public void addBank(bank banks);

    @Update("update bank set bankNum=#{bankNum},bankName=#{bankName}" +
            ",contact=#{contact} where bankNum=#{bankNum}")
    public void updateBank(bank banks);

//    @Delete("delete from bank where bankNum=#{bankNum}")
//    public void deleteBank(String bankNum);
//
//    @Delete("delete from bank where bankName=#{bankName}")
//    public void deleteBanks(String bankName);
}
