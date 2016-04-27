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
    <title>JSP隐式对象</title>
</head>
<body>
<div>
    <br/>JSP的九大隐藏对象<br/><br/><br/>
    <table class="reference">
        <tbody>
        <tr>
            <th><strong>对象</strong></th>
            <th><strong>描述</strong></th>
        </tr>
        <tr>
            <td> request</td>
            <td><strong>HttpServletRequest</strong>类的实例</td>
        </tr>
        <tr>
            <td> response</td>
            <td><strong>HttpServletResponse</strong>类的实例</td>
        </tr>
        <tr>
            <td> out</td>
            <td><strong>PrintWriter</strong>类的实例，用于把结果输出至网页上</td>
        </tr>
        <tr>
            <td> session</td>
            <td><strong>HttpSession</strong>类的实例</td>
        </tr>
        <tr>
            <td> application</td>
            <td><strong>ServletContext</strong>类的实例，与应用上下文有关</td>
        </tr>
        <tr>
            <td> config</td>
            <td><strong>ServletConfig</strong>类的实例</td>
        </tr>
        <tr>
            <td> pageContext</td>
            <td><strong>PageContext</strong>类的实例，提供对JSP页面所有对象以及命名空间的访问</td>
        </tr>
        <tr>
            <td> page</td>
            <td> 类似于Java类中的this关键字</td>
        </tr>
        <tr>
            <td> Exception</td>
            <td><strong>Exception</strong>类的对象，代表发生错误的JSP页面中对应的异常对象</td>
        </tr>
        </tbody>
    </table>
</div>

<div>
    <br/><br/>
    <%
        out.println(request.getRequestURL().toString());
        out.println(request.getSession() == session);//true //这个session和隐藏的session是一个对象

        //基本上全部的隐藏对象都可以通过pageContext拿到
        out.println(pageContext.getSession()==session);//true
        out.println(pageContext.getRequest()==request);//true

    %>
</div>
</body>
</html>
