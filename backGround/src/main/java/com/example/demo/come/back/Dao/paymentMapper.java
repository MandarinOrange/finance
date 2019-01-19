package com.example.demo.come.back.Dao;


import com.example.demo.come.back.bean.Repayment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface paymentMapper {
    @Select("select * from repayment where checkNum = #{checkNum}")
    public Repayment selectPepaymentBycheckNum(long checkNum);

    @Update("update repayment set repAmount = #{repAmount} ,repSum = #{repSum} where checkNum = #{checkNum}")
    public void updateRepayment(Repayment repayment);

    @Insert(" insert into repayment(checkNum,repAmount,repSum) values (#{checkNum},#{repAmount}," +
            "#{repSum})")
    public void addRepayment(Repayment repayment);
}
