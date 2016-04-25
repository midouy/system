<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>JSP cookie 缓存</title>
    <%--Cookie其实就是一个键值对, 而不是一个容器--%>
</head>
<body>

<%

    Cookie nameCookie = new Cookie("name","carol");
    nameCookie.setMaxAge(60*60*24);
    response.addCookie(nameCookie);
    //第一此的不会打印这个cookie, 因为他还没有被存储在客户端上
    //第二次遍历cookie内容的时候就会有 name : carol
%>

<%

  Cookie [] cookies = request.getCookies();
  for(Cookie cookie : cookies)
  {
    System.out.println("cookie printing...");
    out.println(cookie.getName()+" : "+cookie.getValue()+"<br/>");
  }//只打印出了一行 JSESSIONID

%>

</body>
</html>
