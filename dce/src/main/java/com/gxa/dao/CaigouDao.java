package com.gxa.dao;

import com.gxa.entity.Caigou;

import java.sql.SQLException;
import java.util.List;

public interface CaigouDao {
    List<Caigou> selectSellList() throws SQLException;
    boolean save(Caigou caigou) throws SQLException;
    boolean delete(String id) throws SQLException;
}
