package com.gxa.service;

import com.gxa.entity.User;

public interface UserService {
    //根据用户名去查询用户信息
    User queryByName(String name);

}
