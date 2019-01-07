package com.example.demo.Dao;

import com.example.demo.bean.Audit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface auditMapper {
    @Select("select * from audit where checkNum = #{checkNum}")
    public Audit selectAudioByCheckNum(long checkNum);

    @Select("select * from audit")
    public List<Audit> select();

    @Insert("insert into audit(checkNum, userNum, productNum, " +
            "bankAccount, checkState, contractNum, " +
            "isSignContract, year, amount, applyTime)" +
            " values (#{checkNum},#{userNum},#{productNum},#{bankAccount},#{checkState}," +
            "#{contractNum},#{isSignContract},#{year},#{amount},#{applyTime})")
    public void addAudit(Audit audits);

    @Update("update audit set checkNum=#{checkNum},userNum=#{userNum}" +
            ",productNum=#{productNum},checkState=#{checkState},contractNum=#{contractNum}," +
            "isSignContract=#{isSignContract},year=#{year},amount=#{amount}," +
            "applyTime=#{applyTime}where checkNum=#{checkNum}")
    public void updateAudit(Audit audits);

    @Delete("delete from audit where checkNum=#{checkNum}")
    public void deleteAudit(long checkNum);
}
