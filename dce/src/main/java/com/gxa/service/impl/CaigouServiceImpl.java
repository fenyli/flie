package com.gxa.service.impl;

import com.gxa.dao.CaigouDao;
import com.gxa.dao.impl.CaigouDaoImpl;
import com.gxa.entity.Caigou;
import com.gxa.service.CaigouService;

import java.sql.SQLException;
import java.util.List;

public class CaigouServiceImpl implements CaigouService {
    CaigouDao caigouDao;
    public CaigouServiceImpl(){
        caigouDao=new CaigouDaoImpl();
    }

    @Override
    public List<Caigou> selectSellList() throws SQLException {
        return caigouDao.selectSellList();
    }

    @Override
    public boolean save(Caigou sell) throws SQLException {
        return caigouDao.save(sell);
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return caigouDao.delete(id);
    }
}
