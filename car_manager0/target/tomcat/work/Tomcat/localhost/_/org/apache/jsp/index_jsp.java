/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-12-13 13:40:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title></title>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/lib/jquery-3.6.0.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(function (){\r\n");
      out.write("\r\n");
      out.write("            var id = \"\";\r\n");
      out.write("            var $tr = \"\";\r\n");
      out.write("\r\n");
      out.write("            $(\"#add\").on('click',function (){\r\n");
      out.write("                window.location.href = \"/add.jsp\"\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            //异步查询展示列表\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                type: 'get',\r\n");
      out.write("                url: '/car?flag=list',\r\n");
      out.write("                dataType:'json',\r\n");
      out.write("                success:function (data){\r\n");
      out.write("                   var html  =  '';\r\n");
      out.write("\r\n");
      out.write("                   $.each(data, function (index, car){\r\n");
      out.write("                       html += '<tr>';\r\n");
      out.write("                       html += '<th><input type=\"checkbox\" name=\"check\" /></th>';\r\n");
      out.write("                       html += '<td>'+car.id+'</td>';\r\n");
      out.write("                       html += '<td>'+car.brand+'</td>';\r\n");
      out.write("                       html += '<td>'+car.color+'</td>';\r\n");
      out.write("                       html += '<td>'+car.number+'</td>';\r\n");
      out.write("                       html += '<td>'+car.size+'</td>';\r\n");
      out.write("                       html += '</tr>';\r\n");
      out.write("                   })\r\n");
      out.write("                    //一定记得加这个#\r\n");
      out.write("                    $('#list').html(html);\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            //条件查询，可以添一个条件也可以两个\r\n");
      out.write("            $('a[name=\"select\"]').on('click', function (){\r\n");
      out.write("\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    type: 'get',\r\n");
      out.write("                    url: '/car?flag=select',\r\n");
      out.write("                    data: {\r\n");
      out.write("                        brand:$('input[name=\"brand\"]').val(),\r\n");
      out.write("                        color:$('input[name=\"color\"]').val()\r\n");
      out.write("                    },\r\n");
      out.write("                    dataType: 'json',\r\n");
      out.write("                    success:function (data){\r\n");
      out.write("                        var html = '';\r\n");
      out.write("                        $.each(data, function (index, car){\r\n");
      out.write("                            html += '<tr>';\r\n");
      out.write("                            html += '<th><input type=\"checkbox\" name=\"check\" id=\"'+car.id+'\"/></th>';\r\n");
      out.write("                            html += '<td>'+car.id+'</td>';\r\n");
      out.write("                            html += '<td>'+car.brand+'</td>';\r\n");
      out.write("                            html += '<td>'+car.color+'</td>';\r\n");
      out.write("                            html += '<td>'+car.number+'</td>';\r\n");
      out.write("                            html += '<td>'+car.size+'</td>';\r\n");
      out.write("                            html += '</tr>';\r\n");
      out.write("                        })\r\n");
      out.write("                        $('#list').html(html);\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            /*下面事件是删除事件里面的*/\r\n");
      out.write("            //单个多选框绑定事件获取id\r\n");
      out.write("              $('#list').on('click', 'input[name=\"check\"]', function (){\r\n");
      out.write("\r\n");
      out.write("                  $(\"input[name='checkall']\").prop(\"checked\",$(\"input[name='check']:checked\").length == $(\"input[name='check']\").length);\r\n");
      out.write("                  s_id = $(this).attr(\"id\")\r\n");
      out.write("                  $tr = $(this).parent().parent()\r\n");
      out.write("                  id = $(this).parent().parent().find(\"td:eq(0)\").html();\r\n");
      out.write("\r\n");
      out.write("              })\r\n");
      out.write("\r\n");
      out.write("            //复选框绑定单击事件\r\n");
      out.write("            $('input[name=\"checkall\"]').on('click', function (){\r\n");
      out.write("                  $(\"input[name='check']\").prop('checked', $(this).prop(\"checked\"))\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            //删除数据\r\n");
      out.write("            $('a[name=\"delete\"]').on('click', function (){\r\n");
      out.write("\r\n");
      out.write("                if ($('input[name=\"checkall\"]').prop(\"checked\")==true) {\r\n");
      out.write("\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        url: '/car?flag=delete',\r\n");
      out.write("                        dataType: 'text',\r\n");
      out.write("                        success:function (data){\r\n");
      out.write("                            /*此处的data是从后端传递过来的数据*/\r\n");
      out.write("                            if (data == 'success') {\r\n");
      out.write("                                $(\"#list\").empty()\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    })\r\n");
      out.write("                }else {\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        url:'/car?flag=delete',\r\n");
      out.write("                        data:{id:id},\r\n");
      out.write("                        dataType:'text',\r\n");
      out.write("                        success: function (data) {\r\n");
      out.write("                            if (data == \"success\") {\r\n");
      out.write("                                $tr.remove()\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    })\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table align=\"center\" border=\"1\" cellspacing=\"0\" style=\"border-color: aqua\" width=\"850px\">\r\n");
      out.write("    <div align=\"center\">\r\n");
      out.write("        <a href=\"#\" style=\"color: blue;\" id=\"add\">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <a href=\"#\" style=\"color: red;\" id=\"del\" name=\"delete\"> 删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <input name=\"brand\" placeholder=\"请输入汽车品牌\" id=\"brand\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <input name=\"color\" placeholder=\"请输入汽车颜色\" id=\"color\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <a href=\"#\" style=\"color: grey;\" name=\"select\">查询</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th><input type=\"checkbox\" name=\"checkall\" />全选</th>\r\n");
      out.write("        <th>汽车编号</th>\r\n");
      out.write("        <th>汽车品牌</th>\r\n");
      out.write("        <th>汽车颜色</th>\r\n");
      out.write("        <th>汽车车牌</th>\r\n");
      out.write("        <th>汽车尺寸</th>\r\n");
      out.write("\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tbody id=\"list\">\r\n");
      out.write("\r\n");
      out.write("    </tbody>\r\n");
      out.write("       <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
