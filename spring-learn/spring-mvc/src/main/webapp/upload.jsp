<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2022/3/5
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<h1>单文件上传</h1>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br/>
    文件<input type="file" name="uploadFile"><br/>
    <input type="submit" name="上传">
</form>


<h1>多文件上传</h1>
<h1>多文件上传测试</h1>
<form action="${pageContext.request.contextPath}/uploadMultiple" method="post"
      enctype="multipart/form-data">
    名称：<input type="text" name="username"><br>
    文件1：<input type="file" name="uploadFiles"><br>
    文件2：<input type="file" name="uploadFiles"><br>
    文件3：<input type="file" name="uploadFiles"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
