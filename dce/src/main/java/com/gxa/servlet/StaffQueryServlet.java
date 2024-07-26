package com.gxa.servlet;

import com.alibaba.fastjson.JSONObject;
import com.gxa.entity.Staff;
import com.gxa.service.StaffService;
import com.gxa.service.impl.StaffServicelmpl;
import com.gxa.utils.R;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class StaffQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决写到页面的乱码问题
        resp.setContentType("text/json;charset=utf-8");

        //1、接收参数  由于这里没有参数接收
        //2、调用service来获取数据
        StaffService staffService = new StaffServicelmpl();
        List<Staff> staffList = staffService.queryAll();

        //3、staffList写到前端   需要将staffList放到R中带到页面上去
        R r = R.ok().put("data",staffList);//r中包含三个  code msg  staffList
        //将r转换为json字符串
        String jsonStr = JSONObject.toJSONString(r);
        //将jsonStr写到前端页面
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);
    }
}
