<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2016/2/3
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>结算主页</title>
</head>
<body>
<div class = 'main'>
    <div class="list" id="billList">
        <c:forEach items="${list}" var="item">
            ${item.id }--${item.payPerson }--${item.money }
            --(
            <c:if test="${item.shareWYM}">王雁鸣 </c:if>
            <c:if test="${item.shareLRH}">刘偌含 </c:if>
            <c:if test="${item.shareCX}">陈茜 </c:if>
            <c:if test="${item.shareZXW}">张晓巍 </c:if>
            )
            --${item.note }
            <input type="button" value="删除" id="${item.id }" class="delete" onclick="deleteBill(${item.id })"/>
            <br /><br/>
        </c:forEach>
        <input type="button" value="删除全部" onclick="deleteAll()"/>
    </div>
    <br/>
    <hr>
    <br/>
</div>

<div class = "BillPop"  id="BillPop">
    <form>
        <span class = "payPerson">pay : </span>
        <select class = "names">
            <option value="default">请选择付款人</option>
            <option value="王雁鸣">王雁鸣</option>
            <option value="刘偌含">刘偌含</option>
            <option value="陈茜">陈茜</option>
            <option value="张晓巍">张晓巍</option>
        </select></br></br>

        <span class = "payPerson">share : </span></br>
        <input type="checkbox" id="wym_share" class="checkbox">王雁鸣<br/>
        <input type="checkbox" id="lrh_share" class="checkbox">刘偌含<br/>
        <input type="checkbox" id="cx_share" class="checkbox">陈茜<br/>
        <input type="checkbox" id="zxw_share" class="checkbox">张晓巍<br/><br/>
        <input type="checkbox" id="all">全选<br/><br/>

        <span class = "payPerson">note : </span>
        <input type="text" class="note"><br/>
        <span class = "payPerson">money : </span>
        <input type="text" class = "money" ><br/>
        <input type="button" value="提交" id="submit" class="btn" /><br/>
    </form>
    <br/>
    <hr>
    <br/>
</div>
<div>
    <c:forEach items="${result }" var="item">
        ${item }
        <br /><br/>
    </c:forEach>
</div>
</body>

<script type="text/javascript" src="${ctx}/js/jQuery.js"></script>

<script>
        function addBill(){
            var payPerson = $(".names").val();
            var wym_share = $("#wym_share").is(':checked');
            var lrh_share = $("#lrh_share").is(':checked');
            var cx_share = $("#cx_share").is(':checked');
            var zxw_share = $("#zxw_share").is(':checked');
            var money = $(".money").val();
            var note = $(".note").val();
            $.ajax({
                url : "${ctx}/account/addBill",
                dataType : "json",
                type : "post",
                data:{
                    payPerson:payPerson,
                    shareWYM:wym_share,
                    shareLRH:lrh_share,
                    shareCX:cx_share,
                    shareZXW:zxw_share,
                    money:money,
                    note:note
                },
                success : function(data) {
                    if(data.success){
                        alert("Bill add success : "+data.result);
                    }else{
                        alert("Bill add fail : "+data.result);
                    }
                    location.reload();
                }
            });
    };
    function checkMoney(){
        var keyCode = event.keyCode;
        if ((keyCode >= 48 && keyCode <= 57))
        {
            event.returnValue = true;
        } else {
            event.returnValue = false;
        }
    }
    function checkSelectAll(){
        alert("check all");
        if($("#all").is(":checked")){
            $(".checkbox").attr("checked",true);
        }
        else{
            $(".checkbox").attr("checked",false);
        }
    }
    function deleteBill(id){
        $.ajax({
            url : "${ctx}/account/deleteBill",
            dataType : "json",
            type : "post",
            data:{
             id:id
            },
            success : function(data) {
                alert("Bill delete success ! ");
                location.reload();
            }
        });
    }
    function deleteAll(){
            $.ajax({
                url : "${ctx}/account/deleteAll",
                dataType : "json",
                type : "post",
                data:{
                },
                success : function(data) {
                    alert("Bill delete success ! ");
                    location.reload();
                }
            });
        }

</script>

<%--button active--%>
<script>
    $(function(){
        $(".btn").click(function(){
            addBill();
        });
    });

    $(function(){
       $("#all").change(function(){
           checkSelectAll();
       });
    });

</script>

</html>
