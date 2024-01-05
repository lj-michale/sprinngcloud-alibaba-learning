package org.turing.ddd.infrastructure.repository.redis;


import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.turing.ddd.domain.repository.IUserRepository;
import org.turing.ddd.infrastructure.po.UserEntity;
import org.turing.ddd.infrastructure.util.RedisUtil;

/**
 * @descri: 
 *
 * @author: lj.michale
 * @date: 2024/1/5 17:56
 */
@Repository("userRedisRepository")
public class UserRedisRepository implements IUserRepository {

    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    @Override
    public void save(UserEntity userEntity) {
        redisUtil.set("itstack-demo-ddd-userinfo", JSON.toJSONString(userEntity));
    }

    @Override
    public UserEntity query(Long id) {
        String objJson = redisUtil.get("itstack-demo-ddd-userinfo");
        return JSON.parseObject(objJson, UserEntity.class);
    }

}
