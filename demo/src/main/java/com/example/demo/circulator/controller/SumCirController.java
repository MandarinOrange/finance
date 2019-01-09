package com.example.demo.circulator.controller;

import com.example.demo.circulator.service.CirService;
import com.example.demo.circulator.service.EPAIR_CirService;
import com.example.demo.circulator.service.EPR_CirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SumCirController {
    @Autowired
    //private CirService cirService;
    private EPR_CirService epr_cirService;
    @Autowired
    private EPAIR_CirService epair_cirService;

    @GetMapping("/cir/sum")
    public String SumCirculator(HttpServletRequest request, HttpServletResponse response){
        long productNum = Long.parseLong(request.getParameter("productNum"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        int year = Integer.parseInt(request.getParameter("year"));
        int equation = Integer.parseInt(request.getParameter("equation"));

        double sum_principal_and_intrate = 0;
        switch (equation){
            case 1:
                //cirService = new EPAIR_CirService();
                sum_principal_and_intrate = epair_cirService.SumCirculator(productNum,amount,year);
                break;
            case 2:
                //cirService = new EPR_CirService();
                sum_principal_and_intrate = epr_cirService.SumCirculator(productNum,amount,year);
                break;
            default:
                System.out.println("not exit！！");
                break;
        }
        //double sum_principal_and_intrate = cirService.SumCirculator(productNum,amount,year);
        if(sum_principal_and_intrate>=0){
            request.setAttribute("sum",sum_principal_and_intrate);
        }else if(sum_principal_and_intrate==-3){
            return "无此类产品!";
        }else{
            return "计算失败!";
        }

        return "/circulator";
    }
}
