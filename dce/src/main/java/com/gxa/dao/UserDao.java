package com.gxa.dao;

import com.gxa.entity.User;

public interface UserDao {
    //根据用户名去查找用户
    User queryByName(String name);
}
