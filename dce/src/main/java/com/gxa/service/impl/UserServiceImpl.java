package com.gxa.service.impl;

import com.gxa.dao.UserDao;
import com.gxa.dao.impl.UserDaoImpl;
import com.gxa.entity.User;
import com.gxa.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author she
 * @Date 2022/12/29 15:57
 **/
public class UserServiceImpl implements UserService {

    @Override
    public User queryByName(String name) {
        //调用dao 获取数据
        //接口==实现 （父类引用指向子类对象）
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryByName(name);

        return user;
    }
}
