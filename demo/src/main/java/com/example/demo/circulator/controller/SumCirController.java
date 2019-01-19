package com.example.demo.circulator.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.circulator.service.EPAIR_CirService;
import com.example.demo.circulator.service.EPR_CirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SumCirController {
    @Autowired
    //private CirService cirService;
    private EPR_CirService epr_cirService;
    @Autowired
    private EPAIR_CirService epair_cirService;

    @GetMapping("/cirsum")
    public String SumCirculator(HttpServletRequest request, HttpServletResponse response)throws IOException {
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

        System.out.println(sum_principal_and_intrate);
        response.sendRedirect("countCenter.html");
        return "/circulator";
    }


    @GetMapping("/sum")
    public void SumCir(HttpServletRequest request, HttpServletResponse response)throws IOException{
        double amount =0;
        float intrate = 0;
        int year = 0;
        int equation = 0;
        Map map = new HashMap();
        try{
            equation = Integer.parseInt(request.getParameter("equation"));
            amount = Double.parseDouble(request.getParameter("amount"));
            intrate = Float.parseFloat(request.getParameter("intrate"));
            year = Integer.parseInt(request.getParameter("year"));
        }catch (Exception e){
            map.put("value",0);
            String json = JSONObject.toJSONString(map);
            //System.out.println(json);
            response.getWriter().print(json);
            //return json;
        }finally {

        }
        double sum_principal_and_intrate = 0;
        switch (equation){
            case 1:
                //cirService = new EPAIR_CirService();
                sum_principal_and_intrate = epair_cirService.SumCirculator(intrate,amount,year);
                break;
            case 2:
                //cirService = new EPR_CirService();
                sum_principal_and_intrate = epr_cirService.SumCirculator(intrate,amount,year);
                break;
            default:
                System.out.println("not exit！！");
                break;
        }
        //double sum_principal_and_intrate = cirService.SumCirculator(productNum,amount,year);
        if(sum_principal_and_intrate>=0) {
            request.setAttribute("sum", sum_principal_and_intrate);
        }else{
            map.put("value",-2);
            String json = JSONObject.toJSONString(map);
            //System.out.println(json);
            response.getWriter().print(json);
            //return json;
        }

        //System.out.println(sum_principal_and_intrate);
        map.put("value",sum_principal_and_intrate);
        String json = JSONObject.toJSONString(map);
        //System.out.println(json);
        response.getWriter().print(json);


    }
}
