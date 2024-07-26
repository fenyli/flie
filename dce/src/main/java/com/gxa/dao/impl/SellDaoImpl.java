package com.gxa.dao.impl;

import com.gxa.dao.SellDao;
import com.gxa.entity.Sell;
import com.gxa.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellDaoImpl implements SellDao {
    @Override
    public List<Sell> selectSellList() throws SQLException {
        String sql="SELECT * FROM t_sell";
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Sell> sells=new ArrayList<>();
        while (rs.next()){
            String id = rs.getString("id");
            Date datetime = rs.getDate("datetime");
            String price = rs.getString("price");
            String yuangong = rs.getString("yuangong");
            String remark = rs.getString("remark");
            Sell sell=new Sell(id,datetime,price,yuangong,remark);
            sells.add(sell);
        }
        DBConnection.close(rs,ps,connection);
        return sells;
    }

    @Override
    public boolean save(Sell sell) throws SQLException {
        String sql="INSERT INTO t_sell VALUES(?,?,?,?,?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,sell.getId());
        ps.setDate(2,sell.getDatetime());
        ps.setString(3, sell.getPrice());
        ps.setString(4,sell.getYuangong());
        ps.setString(5,sell.getRemark());
        int i = ps.executeUpdate();
        DBConnection.close(ps,connection);
        return i==1;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sql="DELETE FROM t_sell WHERE id=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,id);
        int i = ps.executeUpdate();
        DBConnection.close(ps,connection);
        return i==1;
    }
}
