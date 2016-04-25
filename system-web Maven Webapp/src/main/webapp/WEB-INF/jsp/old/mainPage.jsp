<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/18
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>mainPage</title>
    <link href="${ctx}/css/mainPageCss.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/jQuery.js"></script>
    <script type="text/javascript">

        $(document).ready(function(){
            $("#button").click(function(){
                $("#des").hide();
            });
        });
    </script>

    <script type="text/javascript">

        function ajax(method,url,data){//返回一个Promise对象
            var request = new XMLHttpRequest();
            return new Promise(function(resolve, reject){
                request.onreadystatechange = function(){
                    if(request.readyState===4){
                        if(request.status===200)
                            resolve(request.responseText);
                        else
                            reject(request.status);
                    }
                    else {

                    }
                }
                request.open(method,url);
                request.send(data);
            });
        }

//        var p = ajax("Get" , "/system/user/showUser?name=zhangsan");
//        p.then(function(text){
//            document.getElementById("area").innerHTML = text;
//        }).catch(function(status){
//            document.getElementById("area").innerHTML = "ERROR"+status;
//        });

        $(function(){
           $("#ajax").click(function(){
               var p = ajax("Get" , "/system/user/showUser?name=zhangsan");
               p.then(function(text){
                   document.getElementById("area").innerHTML = text;
               }).catch(function(status){
                   document.getElementById("area").innerHTML = "ERROR"+status;
               });
           });
        });
    </script>
</head>
<body>
    <p id = "des">This my main page!</p>
    <button id = "button">hide</button>
    <button id="ajax">ajax</button>
    <img src="${ctx}/images/22.jpg"/>

    <textarea id="area"></textarea>
</body>
</html>
