package com.gxa.servlet;

import com.alibaba.fastjson.JSON;
import com.gxa.service.CaigouService;
import com.gxa.service.impl.CaigouServiceImpl;
import com.gxa.utils.R;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CaigouDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        CaigouService service=new CaigouServiceImpl();

        try {
            boolean delete = service.delete(id);
            R r;
            if (delete)
                r=R.ok();
            else
                r=R.error();
            PrintWriter writer = response.getWriter();
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
