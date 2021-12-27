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
    <script type="text/javascript">
        $(function (){

            var id = "";
            var $tr = "";

            $("#add").on('click',function (){
                window.location.href = "/add.jsp"
            })

            //异步查询展示列表
            $.ajax({
                type: 'get',
                url: '/car?flag=list',
                dataType:'json',
                success:function (data){
                   var html  =  '';

                   $.each(data, function (index, car){
                       html += '<tr>';
                       html += '<th><input type="checkbox" name="check" /></th>';
                       html += '<td>'+car.id+'</td>';
                       html += '<td>'+car.brand+'</td>';
                       html += '<td>'+car.color+'</td>';
                       html += '<td>'+car.number+'</td>';
                       html += '<td>'+car.size+'</td>';
                       html += '</tr>';
                   })
                    //一定记得加这个#
                    $('#list').html(html);
                }
            })

            //条件查询，可以添一个条件也可以两个
            $('a[name="select"]').on('click', function (){

                $.ajax({
                    type: 'get',
                    url: '/car?flag=select',
                    data: {
                        brand:$('input[name="brand"]').val(),
                        color:$('input[name="color"]').val()
                    },
                    dataType: 'json',
                    success:function (data){
                        var html = '';
                        $.each(data, function (index, car){
                            html += '<tr>';
                            html += '<th><input type="checkbox" name="check" id="'+car.id+'"/></th>';
                            html += '<td>'+car.id+'</td>';
                            html += '<td>'+car.brand+'</td>';
                            html += '<td>'+car.color+'</td>';
                            html += '<td>'+car.number+'</td>';
                            html += '<td>'+car.size+'</td>';
                            html += '</tr>';
                        })
                        $('#list').html(html);
                    }
                })

            })

            /*下面事件是删除事件里面的*/
            //单个多选框绑定事件获取id
              $('#list').on('click', 'input[name="check"]', function (){

                  $("input[name='checkall']").prop("checked",$("input[name='check']:checked").length == $("input[name='check']").length);
                  s_id = $(this).attr("id")
                  $tr = $(this).parent().parent()
                  id = $(this).parent().parent().find("td:eq(0)").html();

              })

            //复选框绑定单击事件
            $('input[name="checkall"]').on('click', function (){
                  $("input[name='check']").prop('checked', $(this).prop("checked"))
            })



            //删除数据
            $('a[name="delete"]').on('click', function (){

                if ($('input[name="checkall"]').prop("checked")==true) {

                    $.ajax({
                        url: '/car?flag=delete',
                        dataType: 'text',
                        success:function (data){
                            /*此处的data是从后端传递过来的数据*/
                            if (data == 'success') {
                                $("#list").empty()
                            }
                        }
                    })
                }else {
                    $.ajax({
                        url:'/car?flag=delete',
                        data:{id:id},
                        dataType:'text',
                        success: function (data) {
                            if (data == "success") {
                                $tr.remove()
                            }
                        }
                    })
                }
            })

        })
    </script>
</head>
<body>
<table align="center" border="1" cellspacing="0" style="border-color: aqua" width="850px">
    <div align="center">
        <a href="#" style="color: blue;" id="add">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" style="color: red;" id="del" name="delete"> 删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="brand" placeholder="请输入汽车品牌" id="brand">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="color" placeholder="请输入汽车颜色" id="color"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" style="color: grey;" name="select">查询</a>
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