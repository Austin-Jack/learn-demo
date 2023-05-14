><%--
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
    }else {  //当用户名和密码不为空 且两次密码一样
        success=true;
    }
    //注册成功时
    if (success) {
%>
<jsp:useBean id="user" class="beans.UserBean" scope="application"/>
<jsp:setProperty name="user" property="name" value="<%=name%>"/>
<jsp:setProperty name="user" property="password" value="<%=password%>"/>

<jsp:forward page="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_5/webapp/zhuCeSuccess.jsp"/>

<%
    }
    else  { //注册失败
%>

<jsp:forward page="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_5/webapp/zhuCeFail.jsp">
    <jsp:param name="message" value="<%=message%>"/>
</jsp:forward>
<%
    }
%>
</body>
</html>
