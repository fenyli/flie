package com.gxa.dao;

import com.gxa.entity.Goods;

import java.util.List;

public interface GoodsDao {
    //查询所有的药品信息
    List<Goods> queryAll();
    //保存药品信息
    void save(Goods goods);

    //根据id删除药品
    void del(Integer id);
}
