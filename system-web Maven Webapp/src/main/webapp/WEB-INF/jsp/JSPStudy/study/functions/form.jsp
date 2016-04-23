<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27x
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Enumeration" %>
<html>
<head>
    <title>JSP 表单处理</title>
</head>
<body>

<p>

  <%

    out.println(request.getParameter("jspName")); //使用request获取客户端表单提交过来的信息

      Enumeration paras = request.getParameterNames();

      while(paras.hasMoreElements())
      {
          out.println(request.getParameter((String)paras.nextElement()));
          out.println("<br/>");
      }

  %>

</p>

</body>
</html>
