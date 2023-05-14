<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/9/29
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销</title>
</head>
<body>
<%
    session.invalidate();//删除会话
    response.sendRedirect(request.getScheme()+"://"+request.getServerName()+":"
    +request.getServerPort()+request.getContextPath()+"/");
%>
</body>
</html>
