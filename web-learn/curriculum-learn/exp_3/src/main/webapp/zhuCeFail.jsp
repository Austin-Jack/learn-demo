<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/9/26
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册失败</title>
    <style>
        h1,a {
            text-align: center;
            display: block;
        }
    </style>
</head>
<body>
<%
    String message = request.getParameter("message");
    if (message.equals("fail01")) {
        message = "用户名或者密码不能为空";
    }
    if (message.equals("fail02")) {
        message = "两次密码不相同";
    }
%>
<h1><%=message%></h1>
<a href="zhuce.jsp">重新注册</a>
</body>
</html>
