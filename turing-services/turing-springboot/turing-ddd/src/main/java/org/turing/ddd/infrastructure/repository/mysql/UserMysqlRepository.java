package org.turing.ddd.infrastructure.repository.mysql;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.turing.ddd.domain.repository.IUserRepository;
import org.turing.ddd.infrastructure.dao.UserDao;
import org.turing.ddd.infrastructure.po.UserEntity;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2024/1/5 17:55
 */
@Repository("userMysqlRepository")
public class UserMysqlRepository implements IUserRepository {

    @Resource
    private UserDao userDao;

    @Override
    public void save(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    @Override
    public UserEntity query(Long id) {
        return userDao.query(id);
    }
}