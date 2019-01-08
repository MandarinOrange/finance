package com.example.demo.productService.tools;


import java.text.SimpleDateFormat;
import java.util.Date;


public class nowTime{
        public String nowTime(){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String time=(String)df.format(new Date());
            return time;
        }
}
