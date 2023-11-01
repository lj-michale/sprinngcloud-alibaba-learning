package org.springcloud.turing.biz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @descri Gitee配置属性
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "oauth.gitee")
public class GiteeProperties {
    /**
     * clientId
     */
    private String clientId;

    /**
     * clientSecret
     */
    private String clientSecret;

    /**
     * Gitee登录类型
     */
    private String grantType;

    /**
     * Gitee回调域名
     */
    private String redirectUrl;

    /**
     * Gitee访问令牌地址
     */
    private String accessTokenUrl;

    /**
     * Gitee用户信息地址
     */
    private String userInfoUrl;
}