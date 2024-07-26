package com.gxa.dao;

import com.gxa.entity.Staff;
import com.gxa.entity.Supplier;

import java.util.List;

public interface StaffDao {

    //查询所有的供应商信息
    List<Staff> queryAll();

    void save(Staff staff);

    void del(Integer id);
}
