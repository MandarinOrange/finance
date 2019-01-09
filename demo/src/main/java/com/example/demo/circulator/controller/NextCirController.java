package com.example.demo.circulator.controller;


import com.example.demo.circulator.service.EPAIR_CirService;
import com.example.demo.circulator.service.EPR_CirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class NextCirController {
    @Autowired
    private EPAIR_CirService epair_cirService;
    @Autowired
    private EPR_CirService epr_cirService;

    @GetMapping("/cir/next")
    public String nextCirculator(HttpServletRequest request,HttpServletResponse response){
        long checkNum = (Long)request.getAttribute("checkNum");
        int equation = (Integer)request.getAttribute("equation");
        double next_principal_and_intrate = 0;
        switch (equation){
            case 1:
                //cirService = new EPAIR_CirService();
                next_principal_and_intrate = epair_cirService.NextCirculator(checkNum);
                break;
            case 2:
                //cirService = new EPR_CirService();
                next_principal_and_intrate = epr_cirService.NextCirculator(checkNum);
                break;
            default:
                System.out.println("not exit！！");
                break;
        }
        //double next_principal_and_intrate = cirService.NextCirculator(checkNum);
        if(next_principal_and_intrate>=0){
            request.setAttribute("next",next_principal_and_intrate);
        }else if(next_principal_and_intrate==-1){
            return "计算失败";
        }else if(next_principal_and_intrate==-2){
            return "未贷款此类业务";
        }else if(next_principal_and_intrate==-3){
            return "无此类业务";
        }
        return "/next";
    }
}
