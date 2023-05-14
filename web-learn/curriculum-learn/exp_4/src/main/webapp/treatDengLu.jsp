<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.HashMap" %>
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
    } else {
        //获取application中的user map
        Map<String, String> userList = (HashMap<String, String>) application.getAttribute("userList");
        //若不为空则查看用户名和密码是否正确
        Iterator<String> iterator = userList.keySet().iterator();
        boolean goOn = true;
        while (iterator.hasNext() && goOn) {
            String key = iterator.next(); //获取用户名    key 和 value可能为null
            String value = userList.get(key); //获取对应的密码
            if (key.equals(name)) {   //匹配到该用户名
                if (value.equals(password)) {  //并且密码匹配
                    success = true;
                    session.setAttribute("isLogin",true);
                    session.setAttribute("name",name);
                } else {
                    success = false;
                    message = "fail02"; //密码错误
                }
                goOn = false;
            } else {
                goOn = true;
            }
        }
        if (goOn == true) {  //遍历完还没找到用户名
            success = false;
            message = "fail03"; //不存在该用户
        }
    }
    if (success){
%>

<jsp:forward page="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_4/webapp/dengLuSuccess.jsp">
    <jsp:param name="name" value="<%=name%>"/>
</jsp:forward>
<%
    }else {
        %>
<jsp:forward page="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_4/webapp/dengluFail.jsp">
    <jsp:param name="message" value="<%=message%>"/>
</jsp:forward>
<%
    }
    %>
</body>
</html>
