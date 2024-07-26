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

/**
 * @ClassName SupplierAddServlet
 * @Description TODO
 * @Author she
 * @Date 2022/12/30 14:23
 **/
public class SupplierAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决写到客户端乱码问题
        resp.setContentType("text/json;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String link = req.getParameter("link");
        String phone = req.getParameter("phone");
        String code = req.getParameter("code");
        String fax = req.getParameter("fax");
        String email = req.getParameter("email");

        System.out.println("name-->" + name +",address-->" + address + ",link-->" + link + ",phone-->" + phone
        +",code-->" + code+",fax--->" + fax + ",email-->" + email);


        //将收集到的数据封装对象
        Supplier supplier = new Supplier();
        supplier.setName(name);
        supplier.setAddress(address);
        supplier.setLink(link);
        supplier.setPhone(phone);
        supplier.setCode(code);
        supplier.setFax(fax);
        supplier.setEmail(email);
        supplier.setStatus(1);//添加的都是正常的


        //调用service做供应商信息的保存操作
        SupplierService supplierService = new SupplierServiceImpl();
        supplierService.add(supplier);

        //向前端页面返回处理的结果
        R r = R.ok();//code msg

        //将r转换为json字符串
        String jsonStr = JSONObject.toJSONString(r);

        //将jsonStr写到客户端 {"code":200,"msg":"success"}
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);


    }
}
