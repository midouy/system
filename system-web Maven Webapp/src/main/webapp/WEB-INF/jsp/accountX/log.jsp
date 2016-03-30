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
        <div class="tr_row">
            <span class="record_id">当前记录编号 :  <span class="red">${record.id }</span></span>&nbsp;&nbsp;&nbsp;
            <span class="record_date">当前记录日期 : <span class="red"> ${record.date }</span></span>&nbsp;&nbsp;&nbsp;
            <input type="button" value="返回首页"  style="width: 80px" onclick="backToIndex()"/>
        </div>
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
        <table>
            <c:forEach items="${allBillLogs }" var="item">
                <tr class="tr_row">
                    <td class="td_id">${item.id }</td>
                    <td class="td_pay name">${item.payer }</td>
                    <td class="td_money">￥${item.money }</td>
                    <td class="td_date">${item.date }</td>
                    <td class="td_note">${item.note }</td>
                    <%--<td><input type="button" value="删除" id="${item.id }" class="delete" style="width: 80px" onclick="deleteBill(${item.id })"/></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
</body>
<script>
    function checkRecord(id){
        window.location.href="${ctx}/accountX/log?recordId="+id;
    }
    function backToIndex(){
        window.location.href="${ctx}/accountX/index";
    }
</script>
</html>
