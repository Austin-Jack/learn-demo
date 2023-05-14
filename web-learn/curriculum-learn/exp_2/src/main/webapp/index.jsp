<%--
  Created by IntelliJ IDEA.
  User: l2215
  Date: 2021/9/15
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>

    <%--用js判断信息合法性--%>
    <script>
        function checkForm() {
            if (document.form1.name.value == "") {
                alert("用户名不能为空");
                document.form1.name.focus();
                return false;
            }
            if (document.form1.password.value == "") {
                alert("密码不能为空")
                document.form1.password.focus();
                return false;
            }
            if (document.form1.password.value != document.form1.confirm.value) {
                alert("两次密码不匹配")
                return false;
            }
            return true;
        }
    </script>

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

        .register table td h3 {
            margin: 20px 0;
        }

        input {
            height: 20px;
        }
    </style>
</head>


<body>
<div class="register">

    <form action="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_2/src/webappbapp/welcome.jsp" method="post" name="form1">
        <table>

            <tr>
                <td colspan="2">
                    <h2>注册页面</h2>
                </td>
            </tr>
            <tr>
                <td colspan="2"><h3>
                   <%
                       String msg = request.getParameter("msg");
                       if (msg!=null) {
                           out.print(msg);
                       }
                   %>

                </h3></td>

            </tr>
            <tr>
                <td><label for="name">姓名：</label></td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td><label for="pass">密码：</label></td>
                <td><input type="password" name="password" id="pass"></td>
            </tr>
            <tr>
                <td><label for="confirm">重复密码:</label></td>
                <td><input type="password" name="confirm" id="confirm"></td>
            </tr>

            <tr>
                <td>
                    性别：
                </td>
                <td>
                    <input type="radio" name="sex" value="男" id="man" checked="checked">男<label for="man"><img
                        src="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_2/src/webappbapp/img/man.png" alt=""></label>
                    &nbsp;&nbsp;
                    <input type="radio" name="sex" value="女" id="woman">女<label for="woman"><img src="development/IdeaProjects/learn-demo/web-learn/curriculum-learn/exp_2/src/webappbapp/img/woman.png"
                                                                                                     alt=""></label>
                </td>
            </tr>

            <tr>
                <td>爱好：</td>
                <td>
                    <input type="checkbox" name="hobby" value="唱" checked="checked">唱&nbsp;
                    <input type="checkbox" name="hobby" value="跳">跳&nbsp;
                    <input type="checkbox" name="hobby" value="篮球">篮球&nbsp;
                    <input type="checkbox" name="hobby" value="rap">rap&nbsp;
                </td>
            </tr>
            <tr>
                <td>
                    自我<br>简介
                </td>
                <td>
                    <textarea name="self_talk" cols="20" rows="5"></textarea>
                </td>
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