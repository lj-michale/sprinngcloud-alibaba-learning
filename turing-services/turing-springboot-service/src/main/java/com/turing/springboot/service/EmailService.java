package com.turing.springboot.service;

import com.turing.springboot.dto.resp.MailDTO;

/**
 * @descri 邮件服务接口
 *
 * @author lj.michale
 * @date 2023-10-25
 */
public interface EmailService {

    /**
     * 发送简单邮件
     *
     * @param mailDTO 邮件信息
     */
    void sendSimpleMail(MailDTO mailDTO);

    /**
     * 发送HTML邮件
     *
     * @param mailDTO 邮件信息
     */
    void sendHtmlMail(MailDTO mailDTO);

}
