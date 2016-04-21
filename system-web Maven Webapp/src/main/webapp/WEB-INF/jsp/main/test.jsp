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
<div>
    <br/><br/><span>SpringMVC 数据传递 : </span><br/><br/>
    <input type="button" value="testArray" onclick="testArray();">
    <input type="button" value="testNormal" onclick="testNormal();">
    <input type="button" value="testBean" onclick="testBean();">
    <input type="button" value="testComplex" onclick="testComplex();">
    <input type="button" value="testComplexString" onclick="complexString();">
</div>

</body>
<script type="text/javascript" src="${ctx}/js/jq_183.js"></script>
<script>

    var saveDataAry=[];
    var data1={"name":"test","address":"gz"};
    var data2={"name":"ququ","address":"gr"};
    saveDataAry.push(data1);
    saveDataAry.push(data2);

    function testArray(){
        $.ajax({
            type:"POST",
            url:"${ctx}/main/test/array",
            dataType:"json",
            contentType:'application/json; charset=UTF-8',
            data:JSON.stringify(saveDataAry),
            success:function(data){
                alert(data)
            }
        });
    }

    function testNormal() {
        var data = {}; //使用自己定义的JS对象作为ajax的传输参数
        data["name"] = "sagelasy";
        data["age"] = 2000;

        $.ajax({
           url: "${ctx}/main/test/normal",
            dataType:"json",
            contentType:'application/json; charset=UTF-8',
            data:data,
//            {
//                name : "sagelasy",
//                age: 2000
//            },
            success:function(data){
                alert(data.message);
            }
        });
    }

    function testBean(){
        $.ajax({
            url: "${ctx}/main/testBean",
            dataType: "json",
            data: {
                name : "sagelasy",
                address: 'storm'
            },
            success: function (data) {
                alert(data.message);
            }
        });
    }

    function testComplex() {
        var data = {}; //使用自己定义的JS对象作为ajax的传输参数
        data["title"] = "sagelasy";
        data["age"] = 2000;
        data["anotherPara"] = "I am another parameter !";

        for(var i = 0; i<saveDataAry.length; i++){
            data["persons["+i+"].name"] = saveDataAry[i].name;
            data["persons["+i+"].address"] = saveDataAry[i].address;
        }

        /**
         * 需要前端自行拼接成以下形式
         name:sagelasy
         age:2000
         persons[0].name:test
         persons[0].address:gz
         persons[1].name:ququ
         persons[1].address:gr
         */
        $.ajax({
            url: "${ctx}/main/complex",
            dataType:"json",
            data:data,
//            {
//                name : "sagelasy",
//                age: 2000,
//                persons : saveDataAry
//            },
            success:function(data){
                alert(data.message);
            }
        });
    }

    function complexString() {
        var users = {};
        users.title = "sagelasy";
        users.age = 20000;
        users.persons = saveDataAry;
        $.ajax({
            url: "${ctx}/main/complexString",
            type : "POST",
            dataType: "json",
            contentType : 'application/json;charset=utf-8',
            data: JSON.stringify(users),
            success: function (data) {
                alert(data.message);
            }
        });
    }

</script>
</html>
