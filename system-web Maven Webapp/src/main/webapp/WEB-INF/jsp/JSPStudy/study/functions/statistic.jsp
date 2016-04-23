<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 访问量统计</title>
</head>
<body>

<%
    Integer count = (Integer)application.getAttribute("accessCount");
    if(count==null)
    {
        out.println("welcome to my page!");
        application.setAttribute("accessCount", 1);
        count=new Integer(1);
    }
    else
    {
        count++;
        application.setAttribute("accessCount",count);
    }
    out.println("<br/> 访问统计 : "+count);

%>

</body>
</html>
