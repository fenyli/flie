package com.gxa.servlet;

import com.alibaba.fastjson.JSONObject;
import com.gxa.entity.User;
import com.gxa.service.UserService;
import com.gxa.service.impl.UserServiceImpl;
import com.gxa.utils.MD5Util;
import com.gxa.utils.R;
import com.gxa.utils.SendMailUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Author she
 * @Date 2022/12/28 11:25
 **/
public class FindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();

        //接收参数
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        System.out.println("username---------------->" + username);
        System.out.println("email---------------->" + email);

        //调用service去将用户信息拿到
        UserService userService = new UserServiceImpl();
        User user = userService.queryByName(username);

        Integer randNum = (int)(Math.random()* (999999)+1);//产生(0,999999]之间的随机数
        String password = String.format("%06d",randNum);//进行六位数补全
        System.out.println(password);
//        修改密码为password
//
//
        if(user != null ) {//根据用户名是查询到了用户信息  == null 说明没有查询到

            R r = R.ok().put("data",user);
            String jsonStr = JSONObject.toJSONString(r);

            out.print(jsonStr);

            System.out.println("r---------------->" + r);
            SendMailUtil.sendCommonMail(email, "找回密码", "你的密码已经重置为"+password);
        }else {
            R r = R.error("用户名不存在！");
            String jsonStr = JSONObject.toJSONString(r);

            out.print(jsonStr);
        }
    }
}
