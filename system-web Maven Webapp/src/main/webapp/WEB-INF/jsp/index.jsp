<%--
  Created by IntelliJ IDEA.
  User: Midouy
  Date: 2016/4/23
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>system main index</title>
</head>
<body>

<div>
    <input type="button" name="accountX" value="AccountX" onclick="toAccountIndex('accountX')">
    <input type="button" name="JSPStudy" value="JSPStudy" onclick="toAccountIndex('JSP')">
    <input type="button" name="mvc" value="MVC" onclick="toAccountIndex('mvc')">
    <input type="button" name="layer" value="Layer" onclick="window.open('${ctx}/html/jQuery.Layer.Dialogs.html');">
</div>

</body>

<script>
    function toAccountIndex(param){
        window.open("${ctx}/"+param+"/index");
    }
</script>
</html>
