package com.car.manage.sys.dao;

import com.car.manage.sys.entity.User;

public interface UserDao {

    /**
     * 功能描述：根据用户的账号来获取用户的信息
     * @param login
     * @return
     */
    User findByLogin(String login);
}
