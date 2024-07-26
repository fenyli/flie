package com.gxa.service;

import com.gxa.entity.Caigou;

import java.sql.SQLException;
import java.util.List;

public interface CaigouService {
    List<Caigou> selectSellList() throws SQLException;
    boolean save(Caigou sell) throws SQLException;
    boolean delete(String id) throws SQLException;
}
