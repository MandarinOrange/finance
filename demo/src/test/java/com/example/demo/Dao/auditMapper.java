package com.example.demo.Dao;

import com.example.demo.bean.audio;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface auditMapper {
    @Select("select * from audio where checkNum = #{checkNum}")
    public audio selectAudioByCheckNum(String checkNum);

    @Select("select * from audio")
    public List<audio> select();

    @Insert("insert into audio(checkNum, userNum, productNum, " +
            "bankAccount, checkState, contractNum, " +
            "isSignContract, year, amount, applyTime)" +
            " values (#{checkNum},#{userNum},#{productNum},#{bankAccount},#{checkState}," +
            "#{contractNum},#{isSignContract},#{year},#{amount},#{applyTime})")
    public void addAudio(audio Audios);

    @Update("update audio set checkNum=#{checkNum},userNum=#{userNum}" +
            ",productNum=#{productNum},checkState=#{checkState},contractNum=#{contractNum}," +
            "isSignContract=#{isSignContract},year=#{year},amount=#{amount}," +
            "applyTime=#{applyTime}where checkNum=#{checkNum}")
    public void updateAudio(audio Audios);

    @Delete("delete from audio where checkNum=#{checkNum}")
    public void deleteAudio(String checkNum);
}
