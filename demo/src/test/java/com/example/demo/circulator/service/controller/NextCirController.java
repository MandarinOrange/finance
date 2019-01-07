package com.example.demo.circulator.service.controller;

import com.example.demo.circulator.service.CirService;
import com.example.demo.circulator.service.EPAIR_CirService;
import com.example.demo.circulator.service.EPR_CirService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class NextCirController {
    //@Autowired
    private CirService cirService;

    @GetMapping("/cir/next")
    public String nextCirculator(HttpServletRequest request,HttpServletResponse response){
        long checkNum = (Long)request.getAttribute("checkNum");
        int equation = (Integer)request.getAttribute("equation");
        switch (equation){
            case 1:
                cirService = new EPAIR_CirService();
                break;
            case 2:
                cirService = new EPR_CirService();
                break;
            default:
                System.out.println("not exit");
                break;
        }
        double next_principal_and_intrate = cirService.NextCirculator(checkNum);
        request.setAttribute("next",next_principal_and_intrate);
        return "/next";
    }
}
