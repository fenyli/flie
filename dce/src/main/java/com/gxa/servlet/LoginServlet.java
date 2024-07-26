package com.gxa.servlet;

import com.alibaba.fastjson.JSONObject;
import com.gxa.entity.User;
import com.gxa.service.UserService;
import com.gxa.service.impl.UserServiceImpl;
import com.gxa.utils.MD5Util;
import com.gxa.utils.R;

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
public class LoginServlet  extends HttpServlet {
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
        String password = req.getParameter("password");

//        System.out.println("username---------------->" + username);
//        System.out.println("password---------------->" + password);


        //调用service去将用户信息拿到
        UserService userService = new UserServiceImpl();
        User user = userService.queryByName(username);

        System.out.println(user);


        //判断user中的密码  和 用户输入 密码是否一致
        //1、先将用户输入密码的进行加密
        String encPwd = MD5Util.MD5(password);
        //2、加密之后密文  再和 数据库中查询到的密文进行比对
        if(user != null ){//根据用户名是查询到了用户信息  == null 说明没有查询到
            String dbPwd = user.getPwd();//从数据库取出的密码

            if(encPwd.equals(dbPwd)) {//密码是正确的
                //向客户端写信息  还要将用户信息写到客户端
                user.setPwd(null);//不要将密码写到客户端
                R r = R.ok().put("data",user);
                String jsonStr = JSONObject.toJSONString(r);

                out.print(jsonStr);
            }else{
                R r = R.error("用户名或者密码不正确");
                String jsonStr = JSONObject.toJSONString(r);

                out.print(jsonStr);
            }
        }else{
            R r = R.error("用户名或者密码不正确");
            String jsonStr = JSONObject.toJSONString(r);

            out.print(jsonStr);
        }




    }


}
