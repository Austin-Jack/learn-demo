<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/10/27
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<s:form action="login">
  <s:textfield key="userName"/>
  <s:password key="userPassword"/>
  <s:submit key="submit"/>
</s:form>
</body>
</html>
