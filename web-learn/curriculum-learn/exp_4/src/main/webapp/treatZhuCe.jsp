<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
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
        Map<String,String> usersList= (HashMap<String, String>) application.getAttribute("userList");
        if (usersList==null){  //第一个用户注册 userList对象还没被创建
            Map<String,String> userList=new HashMap<>();
            application.setAttribute("userList",userList);  //存入application
            userList.put(name,password);
        }else {
            if ((usersList.putIfAbsent(name,password))!=null) { //已存在用户名
                success=false;
                message="fail03";
            }
        }
    }
    //注册成功时
    if (success) {
%>
<jsp:forward page="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_4/webapp/zhuCeSuccess.jsp">
    <jsp:param name="name" value="<%=name%>"/>
</jsp:forward>
<%
    }
    else  { //注册失败
%>

<jsp:forward page="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_4/webapp/zhuCeFail.jsp">
    <jsp:param name="message" value="<%=message%>"/>
</jsp:forward>
<%
    }
%>
</body>
</html>
