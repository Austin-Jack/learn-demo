<%@ page import="beans.UserBean" %>
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
    boolean success = false;     //标识是否登录成功
    if ("".equals(name) || "".equals(password)) {  //判断用户名和密码是否为空
        message = "fail01";
        success = false;
    } else {
        Object obj=application.getAttribute("user");
        if (obj!=null){
            UserBean userBean= (UserBean) obj;
            String userPassword=userBean.getPassword();
            String userName=userBean.getName();
            if (userName.equals(name)&&userPassword.equals(password)){
                success=true;
%>
<jsp:useBean id="user" scope="session" class="beans.UserBean"/>
    <jsp:setProperty name="user" property="name"  value="<%=userName%>"/>
    <jsp:setProperty name="user" property="password" value="<%=userPassword%>"/>
<%
            }else {  //账号或密码错误
                success=false;
                message="fail02";
            }
        }else {
            message="fail03";
            success=false;
        }
    }
    if (success){
%>

<jsp:forward page="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_5/webapp/dengLuSuccess.jsp"/>

<%
    }else {
        %>
<jsp:forward page="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_5/webapp/dengluFail.jsp">
    <jsp:param name="message" value="<%=message%>"/>
</jsp:forward>
<%
    }
    %>
</body>
</html>
