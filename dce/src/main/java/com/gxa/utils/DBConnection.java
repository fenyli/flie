package com.gxa.utils;

import java.sql.*;

/**
 * @ClassName DBConnection
 * @Description TODO
 * @Author she
 * @Date 2022/12/29 15:23
 **/
public class DBConnection {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/aaa";
    private static final String USER_NAME = "root";
    private static final String PWD = "root";

    //获取连接
    public static Connection getConnection(){
        //1、加载驱动
        try {
            Class.forName(DRIVER_NAME);
            //2、获取连接
            Connection connection = DriverManager.getConnection(URL,USER_NAME,PWD);

            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //关闭资源
    public static void close(PreparedStatement ps,Connection connection){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(ResultSet rs,PreparedStatement ps,Connection connection){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

       close(ps,connection);
    }


}
