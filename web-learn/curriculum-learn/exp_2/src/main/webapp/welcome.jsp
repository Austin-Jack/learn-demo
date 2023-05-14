<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/9/15
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎</title>
    <style>
        div {
            width: 400px;
            margin: 100px auto;
        }

        table {
            border-collapse: collapse;
        }
        table td {
            text-align: center;
            border: 1px solid black;
        }
    </style>
</head>

<body>
<%
    request.setCharacterEncoding("UTF-8");   //设置请求字符集为UTF-8
    String name = request.getParameter("name"); //获取表单信息
    String password = request.getParameter("password");
    String confirm=request.getParameter("confirm");
    String message="";
    boolean flag=true;
    if ("".equals(name)||"".equals(password)){  //判断用户名或者密码是否为空
        message="用户名和密码不能为空";
%>
    <jsp:forward page="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_2/src/webappbapp/index.jsp">
        <jsp:param name="msg" value="<%=message%>"></jsp:param>
    </jsp:forward>
<%
    }
    if (!password.equals(confirm)){
        message="两次密码不同";
%>
<jsp:forward page="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_2/src/webappbapp/index.jsp">
    <jsp:param name="msg" value="<%=message%>"></jsp:param>
</jsp:forward>
<%
    }
    String sex = request.getParameter("sex");  //获取性别
    String hobbies[] = request.getParameterValues("hobby"); //获取爱好键值对数组
    String hobby = "";
    for (int i = 0; i < hobbies.length; i++) { //将爱好拼接成一个字符串
        hobby += hobbies[i];
        if (i != hobbies.length - 1) {
            hobby += ",";
        }
    }
    String self = request.getParameter("self_talk");  //获取自我简介
    if("".equals(self)){ //如果自我简述为空
        self = "这个人很懒,什么也没留下~";
    }
%>
<div>


    <table>
        <tr>
            <td colspan="2">
                <h3 align="center" style="padding: 0 15px">注册成功,您的各项信息如下</h3>
            </td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td><%=name%>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><%=password%>
            </td>
        </tr>

        <tr>
            <td>性别:</td>
            <td><%=sex%>
            </td>
        </tr>
        <tr>
            <td>爱好：</td>
            <td><%=hobby%>
            </td>
        </tr>
        <tr>
            <td>自我简介：</td>
            <td>
                <p><%=self%>
                </p>
            </td>
        </tr>
    </table>


</div>
</body>

</html>