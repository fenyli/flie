package com.gxa.servlet;

import com.alibaba.fastjson.JSON;
import com.gxa.entity.Sell;
import com.gxa.service.SellService;
import com.gxa.service.impl.SellServiceImpl;
import com.gxa.utils.R;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class SellAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        Sell sell = JSON.parseObject(reader.readLine(), Sell.class);
        System.out.println(sell.getRemark());
        SellService service=new SellServiceImpl();
        try {
            boolean save = service.save(sell);
            PrintWriter writer = response.getWriter();
            String s;
            if (save)
                s = JSON.toJSONString(R.ok());
            else
                s = JSON.toJSONString(R.error());
            writer.print(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
