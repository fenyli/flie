package com.gxa.dao.impl;

import com.gxa.dao.GoodsDao;
import com.gxa.entity.Goods;
import com.gxa.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    public List<Goods> queryAll() {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM t_goods WHERE status=1";//status=1表示是未删除的数据
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Goods> goodsList = new ArrayList<>();//容器是用来装查询出来的供应商
        try {
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            //对结果集的处理
            while(rs.next()) {
                int id = rs.getInt("id");
                int catelog_id=rs.getInt("catelog_id");
                String name = rs.getString("name");
                int gys_id=rs.getInt("gys_id");
                String danwei = rs.getString("danwei");
                String baozhiqi = rs.getString("baozhiqi");
                String beizhu = rs.getString("beizhu");
                int status = rs.getInt("status");

                //封装成对象
                Goods goods = new Goods();
                goods.setId(id);
                goods.setCatelog_id(catelog_id);
                goods.setName(name);
                goods.setGys_id(gys_id);
                goods.setDanwei(danwei);
                goods.setBaozhiqi(baozhiqi);
                goods.setBeizhu(beizhu);
                goods.setStatus(status);

                //将对象装到容器中
                goodsList.add(goods);


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(rs,ps,connection);
        }
        return goodsList;
    }

    @Override
    public void save(Goods goods) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO t_goods(catelog_id,name,gys_id,danwei,baozhiqi,beizhu,status) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            //设置参数
            ps.setInt(1, goods.getCatelog_id());
            ps.setString(2, goods.getName());
            ps.setInt(3,goods.getGys_id());
            ps.setString(4,goods.getDanwei());
            ps.setString(5,goods.getBaozhiqi());
            ps.setString(6, goods.getBeizhu());
            ps.setInt(7,goods.getStatus());

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
        String sql = "UPDATE t_goods SET status=0 WHERE id=?";

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
