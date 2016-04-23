<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap" %>
<%@ include file="life.jsp" %>
<html>
<head>
    <title>JSP指令</title>
</head>
<body>

Page指令(常用)
Page指令为容器提供当前页面的使用说明。一个JSP页面可以包含多个page指令。
<table class="reference">
    <tbody>
    <tr>
        <th><strong>属性</strong></th>
        <th><strong>描述</strong></th>
    </tr>
    <tr>
        <td> buffer</td>
        <td> 指定out对象使用缓冲区的大小</td>
    </tr>
    <tr>
        <td> autoFlush</td>
        <td> 控制out对象的&nbsp;缓存区</td>
    </tr>
    <tr>
        <td> contentType</td>
        <td> 指定当前JSP页面的MIME类型和字符编码</td>
    </tr>
    <tr>
        <td> errorPage</td>
        <td> 指定当JSP页面发生异常时需要转向的错误处理页面</td>
    </tr>
    <tr>
        <td> isErrorPage</td>
        <td> 指定当前页面是否可以作为另一个JSP页面的错误处理页面</td>
    </tr>
    <tr>
        <td> extends</td>
        <td> 指定servlet从哪一个类继承</td>
    </tr>
    <tr>
        <td> import</td>
        <td> 导入要使用的Java类</td>
    </tr>
    <tr>
        <td> info</td>
        <td> 定义JSP页面的描述信息</td>
    </tr>
    <tr>
        <td> isThreadSafe</td>
        <td> 指定对JSP页面的访问是否为线程安全</td>
    </tr>
    <tr>
        <td> language</td>
        <td> 定义JSP页面所用的脚本语言，默认是Java</td>
    </tr>
    <tr>
        <td> session</td>
        <td> 指定JSP页面是否使用session</td>
    </tr>
    <tr>
        <td> isELIgnored</td>
        <td> 指定是否执行EL表达式</td>
    </tr>
    <tr>
        <td> isScriptingEnabled</td>
        <td> 确定脚本元素能否被使用</td>
    </tr>
    </tbody>
</table>

Include指令(常用)
JSP可以通过include指令来包含其他文件。被包含的文件可以是JSP文件、HTML文件或文本文件。
包含的文件就好像是该JSP文件的一部分，会被同时编译执行。

Taglib指令
JSP API允许用户自定义标签，一个自定义标签库就是自定义标签的集合。
Taglib指令引入一个自定义标签集合的定义，包括库路径、自定义标签。
<%

    HashMap<String, String> map = new HashMap<String, String>();

%>
</body>
</html>
