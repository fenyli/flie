package com.gxa.service.impl;

import com.gxa.dao.GoodsDao;
import com.gxa.dao.impl.GoodsDaoImpl;
import com.gxa.entity.Goods;
import com.gxa.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    @Override
    public List<Goods> queryAll() {
        //调用dao来获取供应商的数据
        GoodsDao goodsDao = new GoodsDaoImpl();
        List<Goods> goodsList = goodsDao.queryAll();
        return goodsList;
    }

    @Override
    public void add(Goods goods) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        goodsDao.save(goods);
    }

    @Override
    public void del(Integer id) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        goodsDao.del(id);
    }
}
