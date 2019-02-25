package com.example.demo.weixin.service;

import org.springframework.stereotype.Service;

@Service
public class DataProcess {
    public boolean dataIsNull(String respXml){
        if(respXml.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
