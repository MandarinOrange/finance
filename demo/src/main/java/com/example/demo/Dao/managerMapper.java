package com.example.demo.Dao;

import com.example.demo.bean.Manager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface managerMapper {
    @Select("select managerNum from manager where managerNum = #{managerName}")
    public long selectManagerByManagerName(String managerName);

    @Select("select count(*) from manager where managerNum = #{managerNum},managerPwd = #{managerPwd}")
    public int selectPwd(long managerNum,String managerPwd);

    @Insert("insert into manager(managerNum, managerName, managerPwd, " +
            "managerRight, telephoneNum) values (#{managerNum},#{managerName}," +
            "#{managerPwd},#{managerRight},#{telephoneNum})")
    public void addManager(Manager managers);

    @Update("update manager set managerNum=#{managerNum},managerName=#{managerName}" +
            ",managerPwd=#{managerPwd},managerRight=#{managerRight},telephoneNum=#{telephoneNum},")
    public void updateManager(Manager managers);

//    @Delete("delete from manager where managerNum=#{managerNum}")
//    public void deleteManager(long managerNum);

}
