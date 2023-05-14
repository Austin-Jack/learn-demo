<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/9/26
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录处理</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");  //设置字符集为UTF-8
    String name = request.getParameter("name"); //获取表单的用户名和密码
    String password = request.getParameter("password");
    String message = "";        //用于存储处理结果
    boolean success = true;     //标识是否登录成功
    if ("".equals(name) || "".equals(password)) {  //判断用户名和密码是否为空
        message = "fail01";
        success = false;
    } else if (!"罗林园".equals(name) || !"20192837".equals(password)) {
        //若不为空则查看用户名和密码是否正确
        message = "fail02";
        success = false;
    }
    if (!success) {  //登录失败
%>
<jsp:forward page="dengluFail.jsp">
    <jsp:param name="message" value="<%=message%>"/>
</jsp:forward>
<%
    } else {
        session.setAttribute("isLogin",true);
%>
<jsp:forward page="dengLuSuccess.jsp">
    <jsp:param name="name" value="<%=name%>"/>
</jsp:forward>
<%
    }
%>
</body>
</html>
