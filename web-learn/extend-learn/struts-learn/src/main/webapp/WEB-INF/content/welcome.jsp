<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/10/27
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录成功</title>
    <style>
        h3, a {
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>
<h3>欢迎您:<s:property value="userName"/>登录成功</h3>
<a href="logout">注销</a>
</body>
</html>
