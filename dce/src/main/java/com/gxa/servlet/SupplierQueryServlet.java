package com.gxa.servlet;

import com.alibaba.fastjson.JSONObject;
import com.gxa.entity.Supplier;
import com.gxa.service.SupplierService;
import com.gxa.service.impl.SupplierServiceImpl;
import com.gxa.utils.R;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName SupplierQueryServlet
 * @Description TODO
 * @Author she
 * @Date 2022/12/30 10:50
 **/
public class SupplierQueryServlet extends HttpServlet {
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
        SupplierService supplierService = new SupplierServiceImpl();
        List<Supplier> supplierList = supplierService.queryAll();

        //3、supplierList写到前端   需要将supplierList放到R中带到页面上去
        R r = R.ok().put("data",supplierList);//r中包含三个  code msg  supplierList
        //将r转换为json字符串
        String jsonStr = JSONObject.toJSONString(r);
        //将jsonStr写到前端页面
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);

    }
}
