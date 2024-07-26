package com.gxa.servlet;

import com.alibaba.fastjson.JSONObject;
import com.gxa.service.StaffService;
import com.gxa.service.impl.StaffServicelmpl;
import com.gxa.utils.R;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StaffDelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");

        //接收客户端传过来的参数
        String id = req.getParameter("id");
        System.out.println("id================>" + id);
        Integer delId = null;
        if(id != null &&!"".equals(id)){//异常数据的校验【保证主体逻辑能正常的书写的时候就要考虑】
            delId = Integer.parseInt(id);

            //删除操作
            StaffService staffService = new StaffServicelmpl();
            staffService.del(delId);

            //向客户端写处理结果
            R r = R.ok();
            String jsonStr = JSONObject.toJSONString(r);
            PrintWriter out = resp.getWriter();
            out.print(jsonStr);
        }else{
            R r = R.error("请输入删除的id");
            String jsonStr = JSONObject.toJSONString(r);
            PrintWriter out = resp.getWriter();
            out.print(jsonStr);
        }



    }
}
