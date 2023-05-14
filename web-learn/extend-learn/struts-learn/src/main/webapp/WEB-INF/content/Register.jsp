<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/10/27
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="register">
    <s:textfield key="userName"/>
    <s:password key="userPassword"/>
    <s:password key="confirmPassword"/>
    <s:submit key="submit"/>
</s:form>
</body>
</html>
