package com.example.demo.Dao;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userMapper {
    @Select("select * from user where userNum = #{userNum}")
    public User selectUserByuserNum(long userNum);

    @Select("select * from user where userName = #{userName}")
    public User selectUserByuserName(String userName);

    @Select("select * from user where telephoneNum = #{telephoneNum}")
    public User selectUserBytelephoneNum(String telephoneNum);

    @Select("select count(*) from user")
    public long count();

    @Select("select * from user")
    public List<User> select();

    @Select("select count(*) from user where userNum = #{userNum} and userPwd = #{userPwd}")
    public int selectPwd(long userNum,String userPwd);

    @Select("select isIdentify from user where userNum = #{userNum}")
    public short selectIsId(long userNum);

    @Insert("insert into user(userNum, userName, userPwd, userRight," +
            " telephoneNum, address, isIdentify, registerTime)" +
            " values (#{userNum},#{userName},#{userPwd},#{userRight}," +
            "#{telephoneNum},#{address},#{isIdentify},#{registerTime})")
    public void addUser(User user);

    @Update("update user set isIdentify=#{isIdentify} where userNum=#{userNum}")
    public void updateIsId(long userNum);

//    @Update("update user set userNum=#{userNum},userName=#{userName}" +
//            ",userPwd=#{userPwd},userRight=#{userRight}," +
//            "telephoneNum=#{telephoneNum},address=#{address}," +
//            "isIdentify=#{isIdentify},registerTime=#{registerTime}where userNum=#{userNum}")
//    public void updateUser(User user);
//
//    @Delete("delete from user where userNum=#{userNum}")
//    public void deleteUser(long userNum);
}
