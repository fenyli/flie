package com.gxa.dao;

import com.gxa.entity.Supplier;

import java.util.List;

public interface SupplierDao {
    //查询所有的供应商信息
    List<Supplier> queryAll();
    //保存供应商信息
    void save(Supplier supplier);

    //根据id删除供应商
    void del(Integer id);
}
