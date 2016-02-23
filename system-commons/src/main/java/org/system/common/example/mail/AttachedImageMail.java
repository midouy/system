package org.system.common.example.mail;

/**
 * Created by wangyanming on 2015/12/28.
 */

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

/**
 * 本类测试邮件中嵌套图片
 *
 * @author sunny
 *
 */
public class AttachedImageMail
{
    public static void main(String[] args) throws Exception
    {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

        // 设定mail server
        senderImpl.setHost("smtp.126.com");

        // 建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        // 注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用，
        // multipart模式
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,
                true);

        // 设置收件人，寄件人
        messageHelper.setTo("yanming14@126.com");
        messageHelper.setFrom("yanming14@126.com");
        messageHelper.setSubject("测试邮件中嵌套图片!！");
        // true 表示启动HTML格式的邮件
        messageHelper.setText(
                "<html><head></head><body><h1>hello!!spring image html mail</h1>"
                        + "<img src=\"cid:aaa\"/></body></html>", true);

        FileSystemResource img = new FileSystemResource(new File("D:/123.jpg"));

        messageHelper.addInline("aaa", img);

        senderImpl.setUsername("yanming14@126.com"); // 根据自己的情况,设置username
        senderImpl.setPassword("14Wangyanmingshi"); // 根据自己的情况, 设置password
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
        prop.put("mail.smtp.timeout", "25000");
        senderImpl.setJavaMailProperties(prop);

        // 发送邮件
        senderImpl.send(mailMessage);

        System.out.println("邮件发送成功..");
    }
}
