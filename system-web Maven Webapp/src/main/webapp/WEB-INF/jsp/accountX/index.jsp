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
                <select id="payer">
                    <option value="default">请选择付款人</option>
                    <c:forEach items="${allUsers }" var="item">
                        <option value="${item.name }">${item.name }</option>
                    </c:forEach>
                </select>

                <span class="payPerson">&nbsp;&nbsp;money : </span>
                <input type="text" id="money" style="width: 200px">

                <span class="payPerson" >note : </span>
                <input type="text" id="note" style="width: 200px">

                </br></br>

                <span class="payPerson">share : </span></br></br>
                <c:forEach items="${allUsers }" var="item">
                    <input type="checkbox" id="${item.name }" class="checkbox">${item.name }<br/><br/>
                </c:forEach>

                <input type="button" value="全选选中" id="selectAll">
                <input type="button" value="全部取消" id="cancelAll">
                <input type="button" value="提交"  id="add_bill_btn" style="width: 80px"/><br/>
            </form>

        </div>
        <div class="results">
            <hr/><br/>
            <table>
                <c:forEach items="${allPayments }" var="item">
                    <tr class="tr_row">
                        <td class="td_pay">${item.from }</td>
                        <td class="td_id">给</td>
                        <td class="td_pay">${item.to }</td>
                        <td class="td_pay">${item.money } </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="all_bills">
            <hr/><br/>
            <div class="tr_row"><input  type="button" value="删除全部" onclick="deleteAll()"/></div>
            <table>
                <c:forEach items="${allBills }" var="item">
                    <tr class="tr_row">
                        <td class="td_id">${item.id }</td>
                        <td class="td_pay">${item.payer }</td>
                        <td class="td_money">${item.money }</td>
                        <td class="td_date">${item.date }</td>
                        <td class="td_note">${item.note }</td>
                        <td><input type="button" value="删除" id="${item.id }" class="delete" style="width: 80px" onclick="deleteBill(${item.id })"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>

<script type="text/javascript" src="${ctx}/js/jq_183.js"></script>

<script>
    function addBill() {
        var payer = $("#payer").val();
        var money = $("#money").val();
        var note = $("#note").val();
        var shares = initShares();

        if(payer=='default'){
            alert("付款人不能为空 !")
            return;
        }
        if(shares.length<=0){
            alert("至少选择一个人 ! ");
            return;
        }

        var sharesData = shares.join("@");

        $.ajax({
            url: "${ctx}/accountX/addBill",
            dataType: "json",
            type: "post",
            data: {
                sharesData: sharesData,
                payer: payer,
                money: money,
                note: note
            },
            success: function (data) {
                if (data.success) {
                    alert("Bill add success !!! ");
                } else {
                    alert("Bill add fail !!! ");
                }
                location.reload();
            }
        });
    };

    function initShares(){
        var result = [];
        $(".checkbox").each(function(){
            if($(this).is(':checked')){
                result.push($(this).attr("id"));
            }
        });
        return result;
    }

    function deleteBill(id) {
        $.ajax({
            url: "${ctx}/accountX/deleteBill",
            dataType: "json",
            type: "post",
            data: {
                id: id
            },
            success: function (data) {
                alert("Bill delete success ! ");
                location.reload();
            }
        });
    }
    function deleteAll() {
        if (confirm("确定删除所有？")) {
            $.ajax({
                url: "${ctx}/accountX/deleteAll",
                dataType: "json",
                type: "post",
                data: {},
                success: function (data) {
                    alert("Bill delete success ! ");
                    location.reload();
                }
            });
        }
        else {
//            alert("点击了取消");
        }
    }
</script>

<%--button active--%>
<script>
    function selectAll() {
        $(".checkbox").attr("checked", true);
    }
    function cancelAll() {
        $(".checkbox").removeAttr("checked");
    }
    $(function () {
        $("#add_bill_btn").click(function () {
            addBill();
        });
    });

    $(function () {
        $("#selectAll").click(function () {
            selectAll();
        });
        $("#cancelAll").click(function () {
            cancelAll();
        });
    });

</script>
</html>
