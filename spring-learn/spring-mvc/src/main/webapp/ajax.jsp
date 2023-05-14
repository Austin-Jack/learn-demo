<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2022/3/5
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/jquery-3.3.1.js"></script>
<script>
    //模拟数据
    var userList = new Array();
    userList.push({name: "zhangsan", age: "20"});
    userList.push({name: "lisi", age: "20"});
    $.ajax({
        type: "POST",
        url: "/spring_mvc/test12",
        data: JSON.stringify(userList),
        contentType: 'application/json;charset=utf-8'
    });
</script>
<body>

</body>
</html>
