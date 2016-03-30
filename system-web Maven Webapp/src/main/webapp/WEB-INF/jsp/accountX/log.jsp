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
<%--<p>Accountx log page!</p>--%>
<div class="main">
    <div class="records">
        <hr/>
        <br/>
        <table>
            <c:forEach items="${allRecords }" var="item">
                <tr class="tr_row">
                    <td class="td_id">${item.id }</td>
                    <td class="td_money">￥${item.money }</td>
                    <td class="td_date">${item.date }</td>
                    <td style="width : 100px"><input type="button" value="查看" id="${item.id }" class="check" style="width: 80px" onclick="checkRecord(${item.id })"/></td>
                    <td class="td_note">${item.note }</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="payLogs">
        <hr/>
        <br/>
        <table>
            <c:forEach items="${allPayLogs }" var="item">
                <tr class="tr_row">
                    <td class="td_pay name">${item.from }</td>
                    <td class="td_id">给</td>
                    <td class="td_pay name">${item.to }</td>
                    <td class="td_pay">￥${item.money } </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="billLogs">
        <hr/>
        <br/>
    </div>

</div>
</body>
</html>
