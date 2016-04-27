<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/28
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<html>
<head>
    <title>Request and Response</title>
</head>
<body>


<%
  Enumeration headerNames = request.getHeaderNames();
  while(headerNames.hasMoreElements()) {
    String paramName = (String)headerNames.nextElement();
    out.print("<tr><td>" + paramName + " : \t</td>\n");
    String paramValue = request.getHeader(paramName);
    out.println("<td> " + paramValue + "</td></tr><br/>\n");
  }
%>

<%
    // 设置每隔5秒自动刷新
    response.setIntHeader("Refresh", 5);
    // 获取当前时间
    Calendar calendar = new GregorianCalendar();
    String am_pm;
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    if(calendar.get(Calendar.AM_PM) == 0)
        am_pm = "AM";
    else
        am_pm = "PM";
    String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
    out.println("Current Time is: " + CT + "\n");
%>

</body>
</html>
