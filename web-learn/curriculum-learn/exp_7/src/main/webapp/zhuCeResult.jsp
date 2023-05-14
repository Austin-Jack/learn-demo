<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/10/13
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>注册结果</title>
    <style>
        h1, a {
            text-align: center;
            display: block;
        }
    </style>
</head>
<body>
<%
    String message = (String) request.getAttribute("message");
    response.setCharacterEncoding("utf-8");
    String name = "";
    if (message == null) {   //为null说明直接访问这个页面
%>
<h1>请先注册</h1>
<%
    response.setHeader("refresh", "3;URL=zhuce.jsp");
} else if ("".equals(message)) {   //为空说明没有错误信息则表示登录成功
    name = request.getParameter("name");
%>
<h1>您好！<%=name%>,注册成功</h1>
<a href="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_7/webapp/denglu.jsp">现在登录</a>

<%
} else { //不为空说明有错误信息 则显示
%>
<h1><%=message%></h1>
<%
        response.setHeader("refresh", "3;URL=zhuce.jsp");
}%>
</body>
</html>
