package com.gxa.service;

import com.gxa.entity.Supplier;

import java.util.List;

public interface SupplierService {
    //查询所有的供应商
    List<Supplier> queryAll();

    //添加供应商
    void add(Supplier supplier);

    //根据id删除供应商
    void del(Integer id);
}
