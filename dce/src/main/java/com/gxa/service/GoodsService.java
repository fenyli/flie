package com.gxa.service;

import com.gxa.entity.Goods;

import java.util.List;

public interface GoodsService {
    //查询所有的药品信息
    List<Goods> queryAll();

    //添加药品信息
    void add(Goods goods);

    //根据id删除药品
    void del(Integer id);
}
