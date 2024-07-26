package com.gxa.service.impl;

import com.gxa.dao.SupplierDao;
import com.gxa.dao.impl.SupplierDaoImpl;
import com.gxa.entity.Supplier;
import com.gxa.service.SupplierService;

import java.util.List;

/**
 * @ClassName SupplierServiceImpl
 * @Description TODO
 * @Author she
 * @Date 2022/12/30 10:48
 **/
public class SupplierServiceImpl implements SupplierService {
    @Override
    public List<Supplier> queryAll() {
        //调用dao来获取供应商的数据
        SupplierDao supplierDao = new SupplierDaoImpl();
        List<Supplier> supplierList = supplierDao.queryAll();
        return supplierList;
    }

    @Override
    public void add(Supplier supplier) {
        SupplierDao supplierDao = new SupplierDaoImpl();
        supplierDao.save(supplier);
    }

    @Override
    public void del(Integer id) {
        SupplierDao supplierDao = new SupplierDaoImpl();
        supplierDao.del(id);
    }
}
