package com.baicaiqiche.springboot.mail;

import com.baicaiqiche.springboot.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author: Harold
 * @CreateDate: 2018/5/11 10:24
 * @Company: 上海闪闪互联网金融信息服务有限公司
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MailApplication.class)
public class MailTest {
    @Autowired
    private MailService mailService;

    /**
     * 测试普通邮件的发送
     */
    @Test
    public void testSimpleMail() {
        mailService.sendSimpleMail();
    }

    @Test
    public void testHtmlMail() {
        mailService.sendHtmlMail();
    }

    @Test
    public void testAttachmentMail() {
        mailService.sendAttachmentsMail();
    }
}
