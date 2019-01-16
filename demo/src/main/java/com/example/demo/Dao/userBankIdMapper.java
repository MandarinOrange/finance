package com.example.demo.Dao;

import com.example.demo.bean.UserBankIdentify;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userBankIdMapper {
    @Select("select * from userBankIdentify where userNum = #{userNum}")
    public UserBankIdentify selectUsageDateByCheckNum(long userNum);

    @Select("select * from userBankIdentify where userNum = #{userNum}")
    public List<UserBankIdentify> selectUserBankByUserNum(long userNum);

    @Select("select * from userBankIdentify")
    public List<UserBankIdentify> select();

    @Insert("insert into userBankIdentify(userNum, bankAccount,trueName," +
            "idNum,telephoneNum, bankAccountIdentify)" +
            " values (#{userNum},#{bankAccount},#{trueName}," +
            "#{idNum},#{telephoneNum},#{bankAccountIdentify})")
    public void addUserBankIdentify(UserBankIdentify userBankIdentifys);

    @Update("update userBankIdentify set userNum=#{userNum                                                                                 },bankAccount=#{bankAccount}" +
            ",trueName=#{trueName},idNum=#{idNum},telephoneNum=#{telephoneNum}," +
            "bankAccountIdentify=#{bankAccountIdentify}")
    public void updateUserBankIdentify(UserBankIdentify userBankIdentifys);

    @Delete("delete from userBankIdentify where userNum=#{userNum}")
    public void deleteUserBankIdentify(long userNum);
}
