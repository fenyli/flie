package com.gxa.service.impl;

import com.gxa.dao.StaffDao;
import com.gxa.dao.impl.StaffDaolmpl;
import com.gxa.entity.Staff;
import com.gxa.service.StaffService;

import java.util.List;

public class StaffServicelmpl implements StaffService {
    @Override
    public List<Staff> queryAll() {
        //调用dao来获取供应商的数据
        StaffDao staffDao = new StaffDaolmpl();
        List<Staff> staffList = staffDao.queryAll();
        return staffList;
    }

    public void add(Staff staff) {
        StaffDao staffDao = new StaffDaolmpl();
        staffDao.save(staff);
    }
    @Override
    public void del(Integer id) {
        StaffDao staffDao = new StaffDaolmpl();
        staffDao.del(id);
    }

}
