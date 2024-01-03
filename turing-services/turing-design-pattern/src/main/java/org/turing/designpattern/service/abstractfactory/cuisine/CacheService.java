package org.turing.designpattern.service.abstractfactory.cuisine;

import java.util.concurrent.TimeUnit;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2024/1/3 18:08
 */
public interface CacheService {

    String get(final String key, int redisType);

    void set(String key, String value, int redisType);

    void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType);

    void del(String key, int redisType);

}