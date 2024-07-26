package com.gxa.dao.impl;

import com.gxa.dao.CaigouDao;
import com.gxa.entity.Caigou;
import com.gxa.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaigouDaoImpl implements CaigouDao {
    @Override
    public List<Caigou> selectSellList() throws SQLException {
        String sql="SELECT * FROM t_caigoumingxi";
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Caigou> caigous=new ArrayList<Caigou>();
        while (rs.next()){
            String id = rs.getString("id");
            Date rukushijian = rs.getDate("rukushijian");
            String zongjine = rs.getString("zongjine");
            String fuzeren = rs.getString("fuzeren");
            String beizhu = rs.getString("beizhu");
            String mingxi = rs.getString("mingxi");
            Caigou caigou=new Caigou(id,rukushijian,zongjine,fuzeren,beizhu,mingxi);
            caigous.add(caigou);
        }
        DBConnection.close(rs,ps,connection);
        return caigous;
    }

    @Override
    public boolean save(Caigou caigou) throws SQLException {
        String sql="INSERT INTO t_caigoumingxi VALUES(?,?,?,?,?,?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,caigou.getId());
        ps.setDate(2,caigou.getRukushijian());
        ps.setString(3, caigou.getZongjine());
        ps.setString(4,caigou.getFuzeren());
        ps.setString(5,caigou.getBeizhu());
        ps.setString(6,caigou.getMingxi());
        int i = ps.executeUpdate();
        DBConnection.close(ps,connection);
        return i==1;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sql="DELETE FROM t_caigoumingxi WHERE id=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,id);
        int i = ps.executeUpdate();
        DBConnection.close(ps,connection);
        return i==1;
    }
}
