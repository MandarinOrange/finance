package com.example.demo.Dao;

import com.example.demo.bean.UsageDate;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface useageDataMapper {
    @Select("select * from usagedate where transactionNum = #{transactionNum}")
    public UsageDate selectUsageDateByCheckNum(int checkNum);

    @Select("select * from usagedate")
    public List<UsageDate> select();

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
    public void deleteUsageDate(int checkNum);
}
