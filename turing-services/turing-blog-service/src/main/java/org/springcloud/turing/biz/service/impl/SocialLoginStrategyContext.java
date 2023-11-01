package org.springcloud.turing.biz.service.impl;

import org.springcloud.turing.biz.common.enums.LoginTypeEnum;
import org.springcloud.turing.biz.dto.req.CodeDTO;
import org.springcloud.turing.biz.service.user.SocialLoginStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @descri 登录策略上下文
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Service
public class SocialLoginStrategyContext {

    @Autowired
    private Map<String, SocialLoginStrategy> socialLoginStrategyMap;

    /**
     * 登录
     *
     * @param data data
     * @param loginTypeEnum 登录枚举
     * @return {@link String} Token
     */
    public String executeLoginStrategy(CodeDTO data, LoginTypeEnum loginTypeEnum) {
        return socialLoginStrategyMap.get(loginTypeEnum.getStrategy()).login(data);
    }

}
