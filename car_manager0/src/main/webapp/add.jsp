<%--
  Created by IntelliJ IDEA.
  User: 姜浩东
  Date: 2021/12/9
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<form action="/car?flag=add" method="post" style="color: grey;">
    汽车品牌<input id="brand" name="brand" type="text" /><br />
    汽车颜色<input id="color" name="color" type="text" /><br />
    汽车车牌<input id="number" name="number" type="text" /><br />
    汽车尺寸<input id="size" name="size" type="text" /><br />
    <input id="add" name="add" type="submit" value="添加" />
</form>
</body>
</html>
