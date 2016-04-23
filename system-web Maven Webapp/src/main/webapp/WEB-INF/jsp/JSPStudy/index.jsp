<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>

    <script type="text/javascript" src="${ctx}/js/jq_183.js"></script>
    <script type="text/javascript">

        $(function(){
           $('.basicButton').click(function(){
                $("#basic input[type=text]").val(this.id);
                $('#basic').submit();
            });

            $('.functionButton').click(function(){
                $("#function input[type=text]").val(this.id);
                $('#function').submit();
            });

            $('.advancedButton').click(function(){
                $("#advanced input[type=text]").val(this.id);
                $('#advanced').submit();
            });

            $('b').css('font-size','17px');
        });

    </script>

</head>
<body>
<h2>Hello World!</h2>

<div>
    <p><b>basic</b></p>

    <form action="${ctx}/JSP/study" id="basic">
        <input type="hidden" name="subContext" value="basic">
        <input type="text" name="jspName">
        <input type="submit">
    </form>

    <button type="button" id="main" class="basicButton">main</button>
    <button type="button" id="grammar" class="basicButton">grammar</button>
    <button type="button" id="command" class="basicButton">command</button>
    <button type="button" id="action" class="basicButton">action</button>
    <button type="button" id="object" class="basicButton">object</button>
    <button type="button" id="http" class="basicButton">http</button>
    <button type="button" id="cookie" class="basicButton">cookie</button>
    <button type="button" id="session" class="basicButton">session</button>

</div>


<div>
    <p><b>functions</b></p>

    <form action="${ctx}/JSP/study" id = "function">
        <input type="hidden" name="subContext" value="functions">
        <input type="text" name="jspName">
        <input type="submit">
    </form>
    <button type="button" id="form" class="functionButton">form</button>
    <button type="button" id="statistic" class="functionButton">statistic</button>
    <button type="button" id="autofresh" class="functionButton">autofresh</button>
    <button type="button" id="redirect" class="functionButton">redirect</button>
    <button type="button" id="mail" class="functionButton">mail</button>
</div>


<div>
    <p><b>advanced</b></p>

    <form action="${ctx}/JSP/study" id="advanced">
        <input type="hidden" name="subContext" value="advanced">
        <input type="text" name="jspName">
        <input type="submit">
    </form>

    <button type="button" id="JSTL" class="advancedButton">JSTL</button>
    <button type="button" id="EL" class="advancedButton">EL</button>
</div>

</body>
</html>
