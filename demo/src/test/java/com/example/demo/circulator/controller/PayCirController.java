package com.example.demo.circulator.controller;

import com.example.demo.circulator.service.PayCirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PayCirController {
    @Autowired
    PayCirService payCirService;

    @PostMapping("/pay")
    public String payAmountCir(long checkNum,double pay){
        int result = payCirService.payAmountCirculator(checkNum,pay);
        if(result==1){
            return "/还款成功";
        }else{
            return"/还款失败";

        }

    }
}
