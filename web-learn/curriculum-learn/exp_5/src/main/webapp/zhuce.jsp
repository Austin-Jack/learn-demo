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
    <title>注册页面</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: "Microsoft YaHei";
        }

        .register table td {
            width: 100px;
            text-align: center;
        }

        textarea {
            resize: none;
            font-size: 16px;
        }

        .register {
            width: 400px;
            margin: 100px auto;
        }

        .register table td h2 {
            margin: 20px 0;
        }

        input {
            height: 20px;
        }
    </style>
</head>

<body>
<div class="register">
    <form action="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_5/webapp/treatZhuCe.jsp" method="post" name="form1">
        <table>

            <tr>
                <td colspan="2">
                    <h2>注册页面</h2>
                </td>
            </tr>

            <tr>
                <td><label for="name">用户名：</label></td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td><label for="pass">密码：</label></td>
                <td><input type="password" name="password" id="pass"></td>
            </tr>
            <tr>
                <td><label for="confirm">密码确认:</label></td>
                <td><input type="password" name="confirm" id="confirm"></td>
            </tr>

            <tr class="form_footer">
                <td>

                </td>
                <td>
                    <input type="submit" value="确定" onclick="">
                    <span style="display: inline-block; width: 50px;"></span>
                    <input type="reset" name="" value="重设" id="">
                </td>
            </tr>
        </table>
    </form>

</div>
</body>

</html>
