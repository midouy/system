<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP动作元素</title>
</head>
<body>


<div>

    与JSP指令元素不同的是，JSP动作元素在请求处理阶段起作用。<br/>

    JSP动作元素是用XML语法写成的。<br/>

    利用JSP动作可以动态地插入文件、重用JavaBean组件、把用户重定向到另外的页面、为Java插件生成HTML代码。<br/>

</div>

<div>
    <table class="reference">
        <tbody>
        <tr>
            <th style="width:30%">语法</th>
            <th>描述</th>
        </tr>
        <tr>
            <td>jsp:include</td>
            <td>在页面被请求的时候引入一个文件。</td>
        </tr>
        <tr>
            <td>jsp:useBean</td>
            <td>寻找或者实例化一个JavaBean。</td>
        </tr>
        <tr>
            <td>jsp:setProperty</td>
            <td>设置JavaBean的属性。</td>
        </tr>
        <tr>
            <td>jsp:getProperty</td>
            <td>输出某个JavaBean的属性。</td>
        </tr>
        <tr>
            <td>jsp:forward</td>
            <td>把请求转到一个新的页面。</td>
        </tr>
        <tr>
            <td>jsp:plugin</td>
            <td>根据浏览器类型为Java插件生成OBJECT或EMBED标记。</td>
        </tr>
        <tr>
            <td>jsp:element</td>
            <td>定义动态XML元素</td>
        </tr>
        <tr>
            <td>jsp:attribute</td>
            <td>设置动态定义的XML元素属性。</td>
        </tr>
        <tr>
            <td>jsp:body</td>
            <td>设置动态定义的XML元素内容。</td>
        </tr>
        <tr>
            <td>jsp:text</td>
            <td>在JSP页面和文档中使用写入文本的模板</td>
        </tr>
        </tbody>
    </table>
</div>

<div>

    <br/><br/>
    常见的属性<br/>
    所有的动作要素都有两个属性：id属性和scope属性。<br/>

    id属性：<br/>
    id属性是动作元素的唯一标识，可以在JSP页面中引用。动作元素创建的id值可以通过PageContext来调用。<br/>

    scope属性：<br/>
    该属性用于识别动作元素的生命周期。 id属性和scope属性有直接关系，scope属性定义了相关联id对象的寿命。 <br/>
    scope属性有四个可能的值： (a) page,<br/> (b)request,<br/> (c)session,<br/> (d) application。<br/>

</div>

<div>
    <br/><br/>
    jsp:include动作元素<br/>

    jsp:include动作元素用来包含静态和动态的文件。该动作把指定文件插入正在生成的页面。语法格式如下：<br/>

    前面已经介绍过include指令，它是在JSP文件被转换成Servlet的时候引入文件，而这里的jsp:include动作不同，插入文件的时间是在页面被请求的时候。<br/>

     以下是include动作相关的属性列表。<br/>

    <jsp:include page="includes/date.jsp" flush="true"></jsp:include>

</div>

<div>

    <jsp:useBean id="user_one" class="org.system.domain.User"></jsp:useBean>
    <jsp:setProperty name="user_one" property="name" value="zhangsan"></jsp:setProperty>
    <jsp:setProperty name="user_one" property="age" value="20"></jsp:setProperty>

    <%
        out.println(user_one.getName()); //zhangsan 使用插入java语句的方式访问
    %>
    <jsp:getProperty name="user_one" property="name"></jsp:getProperty> //使用JSP动作访问

</div>

<div>
    <br/>jsp:forward 动作把请求转到另外的页面。
    <%--<jsp:forward page="grammar.jsp"></jsp:forward>--%>
</div>

<div>
    <br/>

</div>
</body>
</html>
