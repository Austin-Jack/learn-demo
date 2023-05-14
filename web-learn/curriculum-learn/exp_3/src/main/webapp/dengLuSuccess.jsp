<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/9/26
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
  <style>
    h1  {
      text-align: center;
    }
  </style>
</head>

<body>
  <%
    String name = request.getParameter("name");
  %>

  <h1>您好!<%=name%> 登录成功</h1>
</body>
</html>
