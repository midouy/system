<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>JSP 重定向处理</title>
</head>
<body>

<%

    response.sendRedirect("study?subContext=functions&jspName=autofresh");

%>

</body>
</html>
