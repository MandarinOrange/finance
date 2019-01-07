package com.example.demo.Dao;

import com.example.demo.bean.UsageDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface usageDateMapper {
    @Select("select * from usageDate where check = {#checkNum}")
    public UsageDate selectUsageDateByCheckNum(long checkNum);
}
