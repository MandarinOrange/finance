package com.example.demo.Dao;

import com.example.demo.bean.Transaction;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface transMapper {
    @Select("select * from transaction where transactionNum = #{transactionNum}")
    public Transaction selectAudioByCheckNum(int transactionNum);

    @Select("select * from transaction")
    public List<Transaction> select();

    @Insert("insert into transaction(transactionNum, payer, payee," +
            " transactionTime, transactionAmount, note)" +
            " values (#{transactionNum},#{payer},#{payee},#{transactionTime},#{transactionAmount}," +
            "#{note})")
    public void addTransaction(Transaction transactions);

    @Update("update audio set transactionNum=#{transactionNum},payer=#{payer}" +
            ",payee=#{payee},transactionTime=#{transactionTime},transactionAmount=#{transactionAmount}," +
            "note=#{note}")
    public void updateTransaction(Transaction transactions);

    @Delete("delete from audio where transactionNum=#{transactionNum}")
    public void deleteTransaction(int transactionNum);
}
