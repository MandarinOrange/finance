package com.example.demo.Dao;

import com.example.demo.bean.UserBankIdentify;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userBankIdentify {
    @Select("select * from userbankidentify where userName = #{userName}")
    public UserBankIdentify selectUsageDateByCheckNum(String userName);

    @Select("select * from userBankIdentify")
    public List<UserBankIdentify> select();

    @Insert("insert into usagedate(userName, bankAccount,trueName,idNum,telephoneNum, bankAccountIdentify)" +
            " values (#{userName},#{bankAccount},#{bankAccountIdentify})")
    public void addUserBankIdentify(UserBankIdentify userBankIdentifys);

    @Update("update usagedate set userName=#{userName},bankAccount=#{bankAccount}" +
            ",trueName=#{trueName},idNum=#{idNum},telephoneNum=#{telephoneNum}," +
            "bankAccountIdentify=#{bankAccountIdentify}")
    public void updateUserBankIdentify(UserBankIdentify userBankIdentifys);

    @Delete("delete from usagedate where userName=#{userName}")
    public void deleteUserBankIdentify(String userName);
}
