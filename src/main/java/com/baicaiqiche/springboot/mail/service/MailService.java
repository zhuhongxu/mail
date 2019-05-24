package com.baicaiqiche.springboot.mail.service;


/**
 * @Description:
 * @Author: Harold
 * @CreateDate: 2018/5/11 10:10
 * @Company: 上海闪闪互联网金融信息服务有限公司
 */
public interface MailService {
    /**
     * 发送普通的邮件
     *
     * @throws Exception
     */
    void sendSimpleMail();

    /**
     * 发送html邮件
     */
    void sendHtmlMail();

    /**
     * 发送带有附件的邮件
     */
    void sendAttachmentsMail();
}
