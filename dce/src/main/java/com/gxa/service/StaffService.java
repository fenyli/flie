package com.gxa.service;

import com.gxa.entity.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> queryAll();

    void del(Integer delId);

    void add(Staff staff);
}
