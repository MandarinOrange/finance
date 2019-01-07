package com.example.demo.circulator.service.controller;

import com.example.demo.circulator.service.CirculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class NextCirController {
    //@Autowired
    private CirculatorService circulatorService;

    @GetMapping("/cir/next")
    public String nextCirculator(HttpServletRequest request,HttpServletResponse response){
        long checkNum = (Long)request.getAttribute("checkNum");
        int equation = (Integer)request.getAttribute("equation");
        double next_principal_and_intrate = 0;
        switch (equation){
            case 1:
                next_principal_and_intrate = circulatorService.Equal_principal_and_interest_repaymentNextCirculator(checkNum);
                break;
            case 2:
                next_principal_and_intrate = circulatorService.Equal_principal_repaymentNextCirculator(checkNum);
                break;
            default:
                System.out.println("not exit");
                break;
        }
        next_principal_and_intrate = circulatorService.Equal_principal_and_interest_repaymentNextCirculator(checkNum);
        request.setAttribute("next",next_principal_and_intrate);
        return "/next";
    }
}
