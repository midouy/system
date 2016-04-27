<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<html>
<head>
    <title>JSP 自动刷新</title>
</head>
<body>

<%

    response.setIntHeader("refresh",2); //设置 http 相应头 2 秒自动刷新

    Calendar calendar = new GregorianCalendar();
    String amORpm = calendar.get(Calendar.AM_PM)==0?"AM":"PM";

    out.println("Current time : "+calendar.get(Calendar.HOUR)+" : "+
            calendar.get(Calendar.MINUTE)+" : "+calendar.get(Calendar.SECOND)+" "+amORpm);

%>

</body>
</html>
