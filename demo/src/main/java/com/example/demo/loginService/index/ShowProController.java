package com.example.demo.loginService.index;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Product;
import com.example.demo.searchService.service.impl.ProductSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ShowProController extends HttpServlet {
    @Autowired
    private ProductSearchServiceImpl productSearchService;

    @PostMapping("/show")
    public void showIndex(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            List<Product> products = productSearchService.findByCount();
            String json = JSONObject.toJSONString(products);

            response.setCharacterEncoding("utf-8");
            PrintWriter pw = response.getWriter();
            pw.append(json);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
