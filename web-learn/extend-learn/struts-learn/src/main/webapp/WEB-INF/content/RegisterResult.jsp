<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/10/27
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册结果</title>
    <style>
        h3,a{
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>
<s:if test="#request.message==null">
    <h3><s:property value="userName"/>注册成功！</h3>
    <a href="Login">现在登录</a>
</s:if>
<s:else>
    <h3><s:property value="#request.message"/></h3>
    <a href="Register">重新注册</a>
</s:else>
</body>
</html>
