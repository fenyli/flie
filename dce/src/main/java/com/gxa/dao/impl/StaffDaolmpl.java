package com.gxa.dao.impl;

import com.gxa.dao.StaffDao;
import com.gxa.entity.Staff;
import com.gxa.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDaolmpl implements StaffDao {

    public List<Staff> queryAll() {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM t_staff WHERE status=1";//status=1表示是未删除的数据

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Staff> staffList = new ArrayList<>();//容器是用来装查询出来的供应商
        try {
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            //对结果集的处理
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                String zhiwei = rs.getString("zhiwei");
                int quanxian = rs.getInt("quanxian");
                int status = rs.getInt("status");
                int user_id = rs.getInt("user_id");
                //封装成对象
                Staff staff = new Staff();
                staff.setId(id);
                staff.setName(name);
                staff.setSex(sex);
                staff.setAge(age);
                staff.setTel(tel);
                staff.setAddress(address);
                staff.setZhiwei(zhiwei);
                staff.setQuanxian(quanxian);
                staff.setStatus(status);
                staff.setUser_id(user_id);

                //将对象装到容器中
                staffList.add(staff);


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(rs,ps,connection);
        }
        return staffList;
    }

    public void save(Staff staff) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO t_staff(name,age,tel,sex,address,zhiwei,status) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            //设置参数
            ps.setString(1,staff.getName());
            ps.setString(2, String.valueOf(staff.getAge()));
            ps.setString(3,staff.getTel());
            ps.setString(4,staff.getSex());
            ps.setString(5,staff.getAddress());
            ps.setString(6,staff.getZhiwei());
            ps.setInt(7,staff.getStatus());

            //执行
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(ps,connection);
        }
    }
    public void del(Integer id) {
        Connection connection = DBConnection.getConnection();
        //删除 不是真正意义上的删除，而是逻辑上的删除【也就是将这条数据的status改为0】===>更新操作
        String sql = "UPDATE t_staff SET status=0 WHERE id=?";

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            //设置参数
            ps.setInt(1,id);

            //执行
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(ps,connection);
        }
    }
}
