package com.gxa.dao.impl;

import com.gxa.dao.UserDao;
import com.gxa.entity.User;
import com.gxa.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author she
 * @Date 2022/12/29 15:59
 **/
public class UserDaoImpl implements UserDao {
    //实现数据查询工作
    @Override
    public User queryByName(String name) {
        Connection connection = DBConnection.getConnection();
        //3、准备sql
        String sql = "SELECT * FROM t_user WHERE name=?";
        //4、获取PreparedStatement对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            //5、设置参数
            ps.setString(1,name);
            //6、执行
            rs = ps.executeQuery();

            //7、结果集的处理
            if(rs.next()){
                int id = rs.getInt("id");
                String name01 = rs.getString("name");
                String pwd = rs.getString("pwd");
                int status = rs.getInt("status");

                //将其封装为user对象
                User user = new User();
                user.setId(id);
                user.setName(name01);
                user.setPwd(pwd);
                user.setStatus(status);

                return user;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //8、资源释放工作
            DBConnection.close(rs,ps,connection);
        }
        return null;
    }
}
