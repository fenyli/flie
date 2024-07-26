package com.gxa.servlet;

import com.alibaba.fastjson.JSON;
import com.gxa.entity.Sell;
import com.gxa.service.SellService;
import com.gxa.service.impl.SellServiceImpl;
import com.gxa.utils.R;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class SellQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        SellService service=new SellServiceImpl();
        try {
            PrintWriter writer = response.getWriter();
            R r = R.ok().put("data", service.selectSellList());
            writer.print(JSON.toJSONString(r));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
