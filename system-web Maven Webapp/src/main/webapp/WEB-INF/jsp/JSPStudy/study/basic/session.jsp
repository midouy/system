<%--
  Created by IntelliJ IDEA.
  User: wangyanming
  Date: 2015/8/27
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.*" %>
<html>
<head>
    <title>JSP session 会话</title>
</head>
<body>

<%
    Date createTime = new Date(session.getCreationTime());
    Date lastAccessTime = new Date(session.getLastAccessedTime());

  String title = "welcome back  to my page";
  Integer accessCount = new Integer(0);
  String accessCountKey = new String("accessKey");

  String userID = new String("ABCD");
  String userIDKey = new String ("userID");

  if(session.isNew())//初始化session状态
  {
    title = "welcome to my page!";
    session.setAttribute(userIDKey,userID);
    session.setAttribute(accessCountKey,accessCount);
  }
  accessCount = (Integer)session.getAttribute(accessCountKey);
  if(accessCount==null)
      accessCount = new Integer(0);

  //out.println(title+"<br/>");f
  accessCount = accessCount+1;
  userID = (String)session.getAttribute(userIDKey);
  session.setAttribute(accessCountKey,accessCount);
  //out.println(userID+" : access "+accessCount+" times<br/>");

%>

<table border="1" align="center">
    <tr bgcolor="#949494">
        <th>Session info</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>id</td>
        <td><% out.print( session.getId()); %></td>
    </tr>
    <tr>
        <td>Creation Time</td>
        <td><% out.print(createTime); %></td>
    </tr>
    <tr>
        <td>Time of Last Access</td>
        <td><% out.print(lastAccessTime); %></td>
    </tr>
    <tr>
        <td>User ID</td>
        <td><% out.print(userID); %></td>
    </tr>
    <tr>
        <td>Number of visits</td>
        <td><% out.print(accessCount); %></td>
    </tr>
</table>
</body>
</html>
