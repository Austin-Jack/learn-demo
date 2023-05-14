<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/9/26
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <style>
        h1,a {
            text-align: center;
            display: block;
        }


    </style>
</head>
<body>
<%
    String name = request.getParameter("name");
%>
        <h1>您好！<%=name%>,注册成功</h1>
         <a href="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_5/webapp/denglu.jsp">现在登录</a>
</body>
</html>
