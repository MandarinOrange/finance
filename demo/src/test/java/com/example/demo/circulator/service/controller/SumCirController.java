package com.example.demo.circulator.service.controller;

import com.example.demo.circulator.service.CirculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SumCirController {
    //@Autowired
    private CirculatorService circulatorService;

    @GetMapping("/cir/sum")
    public String SumCirculator(HttpServletRequest request, HttpServletResponse response){
        long productNum = Long.parseLong(request.getParameter("productNum"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        int year = Integer.parseInt(request.getParameter("year"));
        int equation = Integer.parseInt(request.getParameter("equation"));

        double sum_principal_and_intrate = 0;
        switch (equation){
            case 1:
                sum_principal_and_intrate = circulatorService.Equal_principal_and_interest_repaymentSumCirculator(productNum,amount,year);
                break;
            case 2:
                sum_principal_and_intrate = circulatorService.Equal_principal_repaymentSumCirculator(productNum,amount,year);
                break;
            default:
                System.out.println("not exit");
                break;
        }
        request.setAttribute("sum",sum_principal_and_intrate);
        return "/circulator";
    }
}
