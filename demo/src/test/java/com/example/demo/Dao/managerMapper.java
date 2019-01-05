package com.example.demo.Dao;

import com.example.demo.bean.manager;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface managerMapper {
    @Select("select * from manager where managerNum = #{managerName}")
    public manager selectManagerByManagerName(int managerName);

    @Insert("insert into manager(managerNum, managerName, managerPwd, " +
            "managerRight, telephoneNum) values (#{managerNum},#{managerName}," +
            "#{managerPwd},#{managerRight},#{telephoneNum})")
    public void addManager(manager managers);

    @Update("update manager set managerNum=#{managerNum},managerName=#{managerName}" +
            ",managerPwd=#{managerPwd},managerRight=#{managerRight},telephoneNum=#{telephoneNum},")
    public void updateManager(manager managers);

//    @Delete("delete from manager where managerNum=#{managerNum}")
//    public void deleteManager(String managerNum);
}
