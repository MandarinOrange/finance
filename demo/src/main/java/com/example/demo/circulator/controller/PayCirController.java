package com.example.demo.circulator.controller;

import com.example.demo.circulator.service.PayCirService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PayCirController {
    //@Autowired
    PayCirService payCirService;

    @PostMapping("/pay")
    public String payAmountCir(long checkNum,double pay){
        int result = payCirService.payAmountCirculator(checkNum,pay);
        if(result==1){
            return "/还款成功!";
        }else if(result==-2){
            return"/未贷款该业务!";
        }else

            return "/还款失败";
    }
}
