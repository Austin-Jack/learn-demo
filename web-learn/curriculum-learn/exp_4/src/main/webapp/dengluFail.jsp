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
        message="用户名或密码不能为空";
    }
    if (message.equals("fail02")){
        message="输入密码错误";
    }
    if (message.equals("fail03")){
        message="不存在该用户";
    }
%>
<h1><%=message%></h1>
<a href="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_4/webapp/denglu.jsp">重新登录</a>
</body>
</html>
