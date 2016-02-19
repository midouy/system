<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JSP EL 表达式 : 表达式语言</title>
</head>
<body>
<jsp:useBean id="userx" class="org.system.domain.User"></jsp:useBean>
<jsp:setProperty name="userx" property="name" value="carol"></jsp:setProperty>
<jsp:setProperty name="userx" property="age" value="${20+6}"></jsp:setProperty>
<%



%>
${userx.name} <br/> ${userx.age}

<%--${namespace:function(param1, param2...)}--%>
<%--${fn:xxxx}大部分都是一些字符串处理函数--%>
${fn:length("string length!")}

<br/>

<%--EL中的隐含对象--%>
jspName : ${param.jspName}
<br/>
${paramValues}
<br/>

${pageContext.request.requestURL}
</body>
</html>
