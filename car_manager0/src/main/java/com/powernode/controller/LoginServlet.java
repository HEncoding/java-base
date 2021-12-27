package com.powernode.controller;

import com.powernode.model.User;
import com.powernode.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : HD
 * @create 2021/12/7 21:16
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //controller调用业务层,初始化servic层对象
       private LoginService loginService =  new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //前端获取数据，把数据封装到实体当中去
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //登录业务层调用
         //调用controller然后返回一个数据库查询出来的对象，判断接下来的走向
        //登录失败  把提示写到前面的span ,  转发到登录页面
        //登录成功   重定向到首页
        User loginUser = loginService.login(user);
        request.getSession().setAttribute("loginUser", loginUser);

        if (loginUser == null) {
                request.setAttribute("msg", "用户名或者密码不正确");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else{
                //之后的请求需要前面发过来的话得加项目名
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }

    }
}
