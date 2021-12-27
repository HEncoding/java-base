<%--
  Created by IntelliJ IDEA.
  User: 姜浩东
  Date: 2021/12/7
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page  contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>

<form action="/login" method="post">

    <table border="1px" width="500px" cellspacing="0px" style="border-color: skyblue;" align="center" >

        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username"/>
                <span id="err" style="color: red">${msg}</span>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="text" name="password" />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登 录" />
            </td>
        </tr>
    </table>

</form>
</body>
</html>