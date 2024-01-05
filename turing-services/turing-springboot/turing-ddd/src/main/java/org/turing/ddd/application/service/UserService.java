package org.turing.ddd.application.service;


import org.turing.ddd.domain.model.aggregates.UserRichInfo;

/**
 * @descri: 应用层用户服务
 *
 * @author: lj.michale
 * @date: 2024/1/5 17:48
 */
public interface UserService {

    UserRichInfo queryUserInfoById(Long id);

}