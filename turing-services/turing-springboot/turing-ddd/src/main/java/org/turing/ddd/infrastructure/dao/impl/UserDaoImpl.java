package org.turing.ddd.infrastructure.dao.impl;

import org.turing.ddd.infrastructure.dao.UserDao;
import org.turing.ddd.infrastructure.po.UserEntity;

public class UserDaoImpl implements UserDao {

    @Override
    public void save(UserEntity userEntity) {
        //TODO 数据库操作
    }

    @Override
    public UserEntity query(Long id) {
        //TODO 数据库操作
        return null;
    }

}