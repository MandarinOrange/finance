package com.example.demo.Dao;

import com.example.demo.bean.UsageDate;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface usageDateMapper {
    @Select("select * from usagedate where transactionNum = #{transactionNum}")
    public UsageDate selectUsageDateByCheckNum(long checkNum);

    @Select("select * from usagedate")
    public List<UsageDate> select();

    @Select("select productNum from usageDate group by productNum order by count(productNum) DESC")
    public List<Integer> selectByCount();

    @Insert("insert into usagedate(checkNum, productNum, userNum," +
            " bankAccount, bankNum, year, amount, startTime)" +
            " values (#{checkNum},#{productNum},#{userNum},#{bankAccount},#{bankNum}," +
            "#{year},#{amount},#{startTime})")
    public void addUsageDate(UsageDate usageDate);

    @Update("update usagedate set checkNum=#{checkNum},productNum=#{productNum}" +
            ",userNum=#{userNum},bankAccount=#{bankAccount},bankNum=#{bankNum}," +
            "year=#{year},amount=#{amount},startTime=#{startTime}")
    public void updateUsageDate(UsageDate usageDate);

    @Delete("delete from usagedate where checkNum=#{checkNum}")
    public void deleteUsageDate(long checkNum);

}
