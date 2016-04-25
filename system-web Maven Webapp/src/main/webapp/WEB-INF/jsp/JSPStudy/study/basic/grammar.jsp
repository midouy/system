<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>JSP 语法</title>
</head>
<body>

<%  out.println("first JSP Page!"); %>

<%--JSP声明--%>
<%! int i= 120; %>
<%! int a, b, c; %>

<%  out.println(i); //120 %>

<%--JSP 表达式--%>
<p> i =  <%=i%></p>
<p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p>

<%--JSP指令--%>
<%--<%@ page ... %>	定义页面的依赖属性，比如脚本语言、error页面、缓存需求等等--%>
<%--<%@ include ... %>	包含其他文件--%>
<%--<%@ taglib ... %>	引入标签库的定义，可以是自定义标签--%>

<%--JSP行为--%>

<%--jsp:include	用于在当前页面中包含静态或动态资源--%>
<%--jsp:useBean	寻找和初始化一个JavaBean组件--%>
<%--jsp:setProperty	设置 JavaBean组件的值--%>
<%--jsp:getProperty	将 JavaBean组件的值插入到 output中--%>
<%--jsp:forward	从一个JSP文件向另一个文件传递一个包含用户请求的request对象--%>
<%--jsp:plugin	用于在生成的HTML页面中包含Applet和JavaBean对象--%>
<%--jsp:element	动态创建一个XML元素--%>
<%--jsp:attribute	定义动态创建的XML元素的属性--%>
<%--jsp:body	定义动态创建的XML元素的主体--%>
<%--jsp:text	用于封装模板数据--%>

<%--JSP 隐含对象--%>

<%--request	             HttpServletRequest类的实例--%>
<%--response	         HttpServletResponse类的实例--%>
<%--out	                 PrintWriter类的实例，用于把结果输出至网页上--%>
<%--session	             HttpSession类的实例--%>
<%--application	     ServletContext类的实例，与应用上下文有关--%>
<%--config	             ServletConfig类的实例--%>
<%--pageContext	     PageContext类的实例，提供对JSP页面所有对象以及命名空间的访问--%>
<%--page	                 类似于Java类中的this关键字--%>
<%--Exception	         Exception类的对象，代表发生错误的JSP页面中对应的异常对象--%>




</body>
</html>
