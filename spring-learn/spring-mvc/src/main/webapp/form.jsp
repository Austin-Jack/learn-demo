<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2022/3/5
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test11" method="post">
    <input type="text" name="userList[0].name"><br>
    <input type="text" name="userList[0].age"><br>
    <input type="text" name="userList[1].name"><br>
    <input type="text" name="userList[1].age"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
