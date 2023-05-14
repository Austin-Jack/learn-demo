<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/9/22
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册处理</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8"); //设置字符集为UTF-8
    String name = request.getParameter("name"); //获取表单中的信息
    String password = request.getParameter("password");
    String confirm = request.getParameter("confirm");
    String message = "";        //处理结果
    boolean success = true;     //标识是否注册成功
    //如果任一为空
    if ("".equals(name) || "".equals(password) || "".equals(password)) {
        message = "fail01";
        success = false;
    }
    else if (!password.equals(confirm)) {//或者两次密码不相等
        message = "fail02";
        success = false;
    }
    //注册失败时
    if (!success) {
%>
<jsp:forward page="zhuCeFail.jsp">
    <jsp:param name="message" value="<%=message%>"/>
</jsp:forward>
<%
    }
    else  {

        //
%>
<jsp:forward page="zhuCeSuccess.jsp">
    <jsp:param name="name" value="<%=name%>"/>
</jsp:forward>
<%
    }
%>


</body>
</html>
