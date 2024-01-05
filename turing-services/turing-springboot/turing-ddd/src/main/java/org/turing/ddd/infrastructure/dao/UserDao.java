package org.turing.ddd.infrastructure.dao;

import org.turing.ddd.infrastructure.po.UserEntity;

public interface UserDao {

    void save(UserEntity userEntity);

    UserEntity query(Long id);

}