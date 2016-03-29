<%--
  Created by IntelliJ IDEA.
  User: Midouy
  Date: 2016/3/28
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>AccountX Index</title>
    <link href="${ctx}/css/accountX/accountX.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <%--<p>Accountx mian page!</p>--%>
    <div class="main">
        <div class="add_bill">
            <hr/><br/>
            <form>
                <span class="payPerson">pay : </span>
                <select class="names">
                    <option value="default">请选择付款人</option>
                    <c:forEach items="${allUsers }" var="item">
                        <option value="${item.name }">${item.name }</option>
                    </c:forEach>
                </select>

                <span class="payPerson">&nbsp;&nbsp;money : </span>
                <input type="text" class="money" style="width: 200px">

                <span class="payPerson">note : </span>
                <input type="text" class="note">

                </br></br>

                <span class="payPerson">share : </span></br></br>
                <c:forEach items="${allUsers }" var="item">
                    <input type="checkbox" id="${item.shortName }_share" class="checkbox">${item.name }<br/><br/>
                </c:forEach>

                <input type="button" value="全选选中" id="selectAll">
                <input type="button" value="全部取消" id="cancelAll">
                <input type="button" value="提交" id="submit" class="btn" style="width: 80px"/><br/>
            </form>

        </div>
        <div class="results">
            <hr/><br/>
        </div>
        <div class="all_bills">
            <hr/><br/>
        </div>
    </div>
</body>
</html>
