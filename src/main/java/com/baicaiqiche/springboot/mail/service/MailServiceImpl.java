package com.baicaiqiche.springboot.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Description:
 * @Author: Harold
 * @CreateDate: 2018/5/11 10:13
 * @Company: 上海闪闪互联网金融信息服务有限公司
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    /**
     * java邮件发送器
     */
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 邮件发送方
     */
    @Value("${spring.mail.username}")
    private String sender;

    //private String to = "zhuhx@degnity.com";
    private String to = "254566610@qq.com";

    @Override
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(sender);
        message.setSubject("my first spring_boot mail");
        message.setText("hello, dear harold, this is the first mail which you send to yourself by spring_boot, " +
                "please cherish every nice day, because the way we use time determines who we " +
                "become, good morning!");
        javaMailSender.send(message);
    }

    @Override
    public void sendHtmlMail() {
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(to);
            helper.setSubject("my first html mail");

            StringBuffer sb = new StringBuffer();
            sb.append("<h1 style=\"text-align: center;\">浙J12345新增的资方报价低于悬赏价格</h1>\n" +
                    "\t\t<table align=\"center\" border=\"1px\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin: 0 auto;\">\n" +
                    "\t\t\t<tr style=\"background: chartreuse;\" style=\"text-align: center;\">\n" +
                    "\t\t\t\t<td>车牌</td>\n" +
                    "\t\t\t\t<td>参考价格</td>\n" +
                    "\t\t\t\t<td>资方</td>\n" +
                    "\t\t\t\t<td>资方报价</td>\n" +
                    "\t\t\t\t<td>无线索价格</td>\n" +
                    "\t\t\t\t<td>良好线索价格</td>\n" +
                    "\t\t\t\t<td>优质线索价格</td>\n" +
                    "\t\t\t\t<td>极好线索价格</td>\n" +
                    "\t\t\t\t<td>实时线索价格</td>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t\t<tr style=\"text-align: center;\">\n" +
                    "\t\t\t\t<td>浙J12345</td>\n" +
                    "\t\t\t\t<td>11111</td>\n" +
                    "\t\t\t\t<td>奇瑞</td>\n" +
                    "\t\t\t\t<td>22222</td>\n" +
                    "\t\t\t\t<td>33333</td>\n" +
                    "\t\t\t\t<td>9999</td>\n" +
                    "\t\t\t\t<td>8888</td>\n" +
                    "\t\t\t\t<td>7777</td>\n" +
                    "\t\t\t\t<td>6666</td>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t</table>");
            helper.setText(sb.toString(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }

    @Override
    public void sendAttachmentsMail() {
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(sender);
            helper.setSubject("first mail with attachment");
            helper.setText("there is a beautiful girl, if you want to know the detail, please see the attachment");
            FileSystemResource file = new FileSystemResource(new File("src/main/resources/IMG_20180322_203912_HHT.jpg"));
            //加入邮件
            helper.addAttachment("girl.jpg", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }
}
