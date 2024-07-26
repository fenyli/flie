package com.gxa.dao.impl;

import com.gxa.dao.SupplierDao;
import com.gxa.entity.Supplier;
import com.gxa.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SupplierDaoImpl
 * @Description TODO
 * @Author she
 * @Date 2022/12/30 10:36
 **/
public class SupplierDaoImpl implements SupplierDao {
    @Override
    public List<Supplier> queryAll() {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM t_supplier WHERE status=1";//status=1表示是未删除的数据

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Supplier> supplierList = new ArrayList<>();//容器是用来装查询出来的供应商
        try {
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            //对结果集的处理
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String link = rs.getString("link");
                String phone = rs.getString("phone");
                String code = rs.getString("code");
                String fax = rs.getString("fax");
                String email = rs.getString("email");
                int status = rs.getInt("status");

                //封装成对象
                Supplier supplier = new Supplier();
                supplier.setId(id);
                supplier.setName(name);
                supplier.setAddress(address);
                supplier.setLink(link);
                supplier.setPhone(phone);
                supplier.setCode(code);
                supplier.setFax(fax);
                supplier.setEmail(email);
                supplier.setStatus(status);

                //将对象装到容器中
                supplierList.add(supplier);


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(rs,ps,connection);
        }
        return supplierList;
    }

    @Override
    public void save(Supplier supplier) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO t_supplier(name,address,link,phone,code,fax,email,status) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            //设置参数
            ps.setString(1,supplier.getName());
            ps.setString(2,supplier.getAddress());
            ps.setString(3,supplier.getLink());
            ps.setString(4,supplier.getPhone());
            ps.setString(5,supplier.getCode());
            ps.setString(6,supplier.getFax());
            ps.setString(7,supplier.getEmail());
            ps.setInt(8,supplier.getStatus());

            //执行
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(ps,connection);
        }
    }

    @Override
    public void del(Integer id) {
        Connection connection = DBConnection.getConnection();
        //删除 不是真正意义上的删除，而是逻辑上的删除【也就是将这条数据的status改为0】===>更新操作
        String sql = "UPDATE t_supplier SET status=0 WHERE id=?";

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
