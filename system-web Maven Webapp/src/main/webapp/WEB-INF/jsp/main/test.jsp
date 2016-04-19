<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2016/4/19
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>main test !</title>
</head>
<body>

</body>
<script type="text/javascript" src="${ctx}/js/jq_183.js"></script>
<script>
    function testArray(){
        var saveDataAry=[];
        var data1={"name":"test","address":"gz"};
        var data2={"name":"ququ","address":"gr"};
        saveDataAry.push(data1);
        saveDataAry.push(data2);
        $.ajax({
            type:"POST",
            url:"${ctx}/main/test/array",
            dataType:"json",
            contentType:'application/json; charset=UTF-8',
            data:JSON.stringify(saveDataAry),
            success:function(data){

            }
        });
    }
</script>
</html>
