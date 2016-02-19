<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<html>
<head>
    <title>JSP 发送邮件</title>
    <%--失败了...--%>
</head>
<body>

<%
    String result ;

    String to = "837291157@qq.com";

    String from = "837291157@qq.com";

    String host = "localhost";

    Properties properties = System.getProperties();

    properties.setProperty("mail.smtp.host",host);

    properties.setProperty("mail.user","837291157@qq.com");

    properties.setProperty("mail.password","GGn9566%10143030");

    Session mailsession = Session.getDefaultInstance(properties);

    try
    {
        MimeMessage message = new MimeMessage(mailsession);

        message.setFrom(new InternetAddress(from));

        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(to));

        message.setSubject("this is the subject line");

        message.setText("this is the text!");

        Transport.send(message);

        result = "sent message successfully!";
    }catch (Exception e)
    {
        e.printStackTrace();
        result = "Error : unable to send the message! ";
    }



%>

<%=result%>

</body>
</html>
