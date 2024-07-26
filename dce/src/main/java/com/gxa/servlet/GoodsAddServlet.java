package com.gxa.servlet;

import com.alibaba.fastjson.JSONObject;
import com.gxa.entity.Goods;
import com.gxa.service.GoodsService;
import com.gxa.service.impl.GoodsServiceImpl;
import com.gxa.utils.R;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodsAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决写到客户端乱码问题
        resp.setContentType("text/json;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        Integer catelog_id= Integer.valueOf(req.getParameter("catelog_id"));
        String name = req.getParameter("name");
        Integer gys_id= Integer.valueOf(req.getParameter("gys_id"));
        String danwei = req.getParameter("danwei");
        String baozhiqi = req.getParameter("baozhiqi");
        String beizhu = req.getParameter("beizhu");

        System.out.println("catelog_id-->" + catelog_id +",name-->" + name + ",gys_id-->" + gys_id + ",danwei-->" + danwei
                +",baozhiqi-->" + baozhiqi+",beizhu--->" + beizhu);

        //将收集到的数据封装对象
        Goods goods = new Goods();
        goods.setCatelog_id(catelog_id);
        goods.setName(name);
        goods.setGys_id(gys_id);
        goods.setDanwei(danwei);
        goods.setBaozhiqi(baozhiqi);
        goods.setBeizhu(beizhu);
        goods.setStatus(1);//添加的都是正常的



        //调用service做供应商信息的保存操作
        GoodsService goodsService = new GoodsServiceImpl();
        goodsService.add(goods);

        //向前端页面返回处理的结果
        R r = R.ok();//code msg

        //将r转换为json字符串
        String jsonStr = JSONObject.toJSONString(r);

        //将jsonStr写到客户端 {"code":200,"msg":"success"}
        PrintWriter out = resp.getWriter();
        out.print(jsonStr);
    }
}
