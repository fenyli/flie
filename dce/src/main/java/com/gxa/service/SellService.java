package com.gxa.service;

import com.gxa.entity.Sell;

import java.sql.SQLException;
import java.util.List;

public interface SellService {
    List<Sell> selectSellList() throws SQLException;
    boolean save(Sell sell) throws SQLException;
    boolean delete(String id) throws SQLException;
}
