<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/10/14
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.lly.beans.UserBean" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>登录结果</title>
    <style>
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
<%
    String message = (String) request.getAttribute("message");
    String name="";
    if (message!=null){  //来自于登录表单
        if (message.equals("")){  //message存在但内容为空 则表示从表单登录
            name=request.getParameter("name");  //获取同一个request中的name
            name=new String(name.getBytes("iso-8859-1"),"utf-8");   //解决乱码输出
            out.println("<h1>欢迎您:"+name+"登录成功！</h1>");
        }else {   //存在内容不为空则表示有错误信息
            //显示错误信息
            out.println("<h1>"+message+"</h1>");
        }
    }else {   //为null时
        UserBean  user= (UserBean) session.getAttribute("user");
        if (user!=null){   //表示通过session登录
            name=user.getName();
            name=new String(name.getBytes("iso-8859-1"),"utf-8");   //解决乱码输出键值对
            out.println("<h1>欢迎您:"+name+"登录成功！</h1>");
        }else { //没有登录过 或者session失效 直接访问这个页面时
            out.println("<h1>您还未曾登录,请先登录！</h1>");
            response.setHeader("refresh","3;URL=denglu.jsp");
        }
    }
%>
</body>
</html>
