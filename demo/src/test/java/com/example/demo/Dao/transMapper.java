package com.example.demo.Dao;

import com.example.demo.bean.transaction;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface transMapper {
    @Select("select * from transaction where transactionNum = #{transactionNum}")
    public transaction selectAudioByCheckNum(int transactionNum);

    @Select("select * from transaction")
    public List<transaction> select();

    @Insert("insert into transaction(transactionNum, payer, payee," +
            " transactionTime, transactionAmount, note)" +
            " values (#{transactionNum},#{payer},#{payee},#{transactionTime},#{transactionAmount}," +
            "#{note})")
    public void addTransaction(transaction transactions);

    @Update("update audio set transactionNum=#{transactionNum},payer=#{payer}" +
            ",payee=#{payee},transactionTime=#{transactionTime},transactionAmount=#{transactionAmount}," +
            "note=#{note}")
    public void updateTransaction(transaction transactions);

    @Delete("delete from audio where transactionNum=#{transactionNum}")
    public void deleteTransaction(int transactionNum);
}
