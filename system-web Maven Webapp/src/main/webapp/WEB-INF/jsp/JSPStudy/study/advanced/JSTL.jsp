<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="my" uri="http://midouy.study.com/jsp/tld/myTags"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
ff
<html>
<head>
    <title>JSP 标准标签库</title>
</head>
<body>

<jsp:useBean id="userx" class="org.system.domain.User"></jsp:useBean>
<jsp:setProperty name="userx" property="name" value="carol"></jsp:setProperty>
<jsp:setProperty name="userx" property="age" value="${20+6}"></jsp:setProperty>

<%--<c:XXX>--%>
<c:out value="${userx.name}"></c:out>

<c:set var="data1" value="haha"></c:set>

<div>
    ${data1}
</div>
<%--可以显示--%>
<c:if test="true">1==1</c:if>

<%--不能显示--%>
<c:if test="false">1==2</c:if>

<c:choose>
    <c:when test="true">1==1</c:when>
    <c:otherwise>1!=1</c:otherwise>
</c:choose>

<c:forEach var="i" begin="1" end="5">
    <br/>
    Item <c:out value="${i}"></c:out>
</c:forEach>

<%--重定向到另外一个页面--%>
<%--<c:redirect url="advanced?jspName=EL"></c:redirect>--%>
<%--跳转到另外一个页面--%>
<%--<jsp:forward page="EL.jsp"></jsp:forward>--%>

<c:import var="data" url="http://www.w3cschool.cc"></c:import>
<%--<c:out value="${data}"></c:out>--%>

<a href="<c:url value="advanced?jspName=JSTL"/>">刷新本页面</a>


<%--fmt 格式化标签, 用于数据格式化显示--%>
<%--<fmt:XXX>--%>

<%--SQL 标签, 用于数据库信息查询--%>
<%--<sql:XXX>--%>

<%--JSTL 函数--%>
<%--${fn:XXXXX}--%>
<%--一些用于字符串处理的函数--%>
http://www.runoob.com/jsp/jsp-jstl.html

<div>
    
    <p>自定义标签库测试</p>
    <p>${my:hello('midouy')}</p>
    
</div>

</body>
</html>
