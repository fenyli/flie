package com.gxa.servlet;

import com.alibaba.fastjson.JSONObject;
import com.gxa.entity.Staff;
import com.gxa.service.StaffService;
import com.gxa.service.impl.StaffServicelmpl;
import com.gxa.utils.R;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName StaffAddServlet
 * @Description TODO
 * @Author she
 * @Date 2022/12/30 14:23
 **/
public class StaffAddServlet extends HttpServlet {
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
        int age = Integer.parseInt(req.getParameter("age"));
        String tel = req.getParameter("tel");
        String sex = req.getParameter("sex");
        String address = req.getParameter("address");
        String zhiwei = req.getParameter("zhiwei");

        System.out.println("name-->" + name +",age-->" + age + ",tel-->" + tel + ",sex-->" + sex
        +",address-->" + address+",zhiwei--->" + zhiwei);


        //将收集到的数据封装对象
        Staff staff = new Staff();
        staff.setName(name);
        staff.setAge(age);
        staff.setTel(tel);
        staff.setSex(sex);
        staff.setAddress(address);
        staff.setZhiwei(zhiwei);
        staff.setStatus(1);//添加的都是正常的


        //调用service做供应商信息的保存操作
        StaffService staffService = new StaffServicelmpl();
        staffService.add(staff);

        //向前端页面返回处理的结果
        R r = R.ok();//code msg

        //将r转换为json字符串
        String jsonStr = JSONObject.toJSONString(r);

        //将jsonStr写到客户端 {"code":200,"msg":"success"}
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);


    }
}
