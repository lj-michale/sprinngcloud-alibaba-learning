package org.turing.ddd.infrastructure.repository;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.turing.ddd.domain.repository.IUserRepository;
import org.turing.ddd.infrastructure.po.UserEntity;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2024/1/5 17:55
 */
@Repository("userRepository")
public class UserRepository implements IUserRepository {

    @Resource(name = "userMysqlRepository")
    private IUserRepository userMysqlRepository;

    @Resource(name = "userRedisRepository")
    private IUserRepository userRedisRepository;

    @Override
    public void save(UserEntity userEntity) {
        //保存到DB
        userMysqlRepository.save(userEntity);

        //保存到Redis
        userRedisRepository.save(userEntity);
    }

    @Override
    public UserEntity query(Long id) {

        UserEntity userEntityRedis = userRedisRepository.query(id);
        if (null != userEntityRedis) return userEntityRedis;

        UserEntity userEntityMysql = userMysqlRepository.query(id);
        if (null != userEntityMysql){
            //保存到Redis
            userRedisRepository.save(userEntityMysql);
            return userEntityMysql;
        }

        // 查询为NULL
        return null;
    }

}