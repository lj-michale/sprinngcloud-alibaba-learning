package org.turing.ddd.domain.repository;


import org.turing.ddd.infrastructure.po.UserEntity;

/**
 * @descri: 
 *
 * @author: lj.michale
 * @date: 2024/1/5 17:52
 */
public interface IUserRepository {

    void save(UserEntity userEntity);

    UserEntity query(Long id);

}