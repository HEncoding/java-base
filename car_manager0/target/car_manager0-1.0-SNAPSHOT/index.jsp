<%--
  Created by IntelliJ IDEA.
  User: 姜浩东
  Date: 2021/12/9
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script type="text/javascript" src="/lib/jquery-3.6.0.js"></script>
    <script>
        $(function (){

            $("#add").on('click',function (){
                window.location.href = "/add.jsp"
            })

            $.ajax({
                url: '/car?flag=list',
                type: 'get',
                dataType:'json',
                success:function (data){
                    html +=  '';
                   $.each(data, function (index, car){
                       html += '<tr>';
                       html += '<th><input type="checkbox" name="check" /></th>';
                       html += '<td>car.id</td>';
                       html += '<td>car.brand</td>';
                       html += '<td>car.color</td>';
                       html += '<td>car.number</td>';
                       html += '<td>car.size</td>';
                       html += '</tr>';
                   })
                    $('list').html(html);
                }
            })

        })
    </script>
</head>
<body>
<table align="center" border="1" cellspacing="0" style="border-color: aqua" width="850px">
    <div align="center">
        <a href="#" style="color: blue;" id="add">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" style="color: red;" id="del"> 删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="c_brand" value="请输入汽车品牌" id="brand">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="c_color" value="请输入汽车颜色" id="color"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" style="color: grey;">查询</a>
    </div>
    <tr>
        <th><input type="checkbox" name="checkall" />全选</th>
        <th>汽车编号</th>
        <th>汽车品牌</th>
        <th>汽车颜色</th>
        <th>汽车车牌</th>
        <th>汽车尺寸</th>

    </tr>
    <tbody id="list">

    </tbody>
       <span>${requestScope.msg}</span>
</table>
</body>
</html>

</body>
</html>