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
    <title>登录失败</title>
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
%>
<h1>账号或者密码不能为空</h1>
<%
    }
    if (message.equals("fail02")) {
%>
<h1>用户名或者密码错误</h1>
<%
    }
%>
<a href="denglu.jsp">重新登录</a>
</body>
</html>
