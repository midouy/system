package org.system.util.mail;

/**
 * Created by wangyanming on 2015/12/28.
 */
public class MailTest
{
    public void test(){
        //这个类主要是设置邮件
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.126.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("yanming14@126.com");
        mailInfo.setPassword("14Wangyanmingshi");//您的邮箱密码
        mailInfo.setFromAddress("yanming14@126.com");
        mailInfo.setToAddress("yanming14@126.com");
        mailInfo.setSubject("test");
        mailInfo.setContent("试一下");
        //这个类主要来发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        sms.sendTextMail(mailInfo);//发送文体格式
        sms.sendHtmlMail(mailInfo);//发送html格式
    }
}
