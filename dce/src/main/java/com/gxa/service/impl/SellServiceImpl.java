package com.gxa.service.impl;

import com.gxa.dao.SellDao;
import com.gxa.dao.impl.SellDaoImpl;
import com.gxa.entity.Sell;
import com.gxa.service.SellService;

import java.sql.SQLException;
import java.util.List;

public class SellServiceImpl implements SellService {
    SellDao sellDao;
    public SellServiceImpl(){
        sellDao=new SellDaoImpl();
    }

    @Override
    public List<Sell> selectSellList() throws SQLException {
        return sellDao.selectSellList();
    }

    @Override
    public boolean save(Sell sell) throws SQLException {
        return sellDao.save(sell);
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return sellDao.delete(id);
    }
}
