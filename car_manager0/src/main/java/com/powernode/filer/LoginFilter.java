package com.powernode.filer;

import com.powernode.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : HD
 * @create 2021/12/8 9:14
 * <p>
 * 1.登录时，需要把用户信息从数据库返回出来
 * 2.登录成功，servlet中把用户信息存储到session会话域中去
 * 3.登录过滤器配置
 * 4.登录过滤器放行必要(登录页面，登录请求)的请求
 * 5.登录过滤器判断session会话域中是否可以获取用户信息，如果能获取，说明已经登录过，可以放行。如果不能获取，则重定向到登录页面
 * 重新登录
 */

public class LoginFilter implements Filter {
    //初始化过滤器获取形参
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //过滤器核心业务
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取request和response对象，(HttpServletRequest是ServletRquest的的子类，可以直接向下转型)
        //判断  放行登录页面和登录后台的请求，否则无法登录
        //     其它的请求 利用登录后的session取中取出的对象来判断   是否已经登录，登录放行，没有登录则跳转到登录页面
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Boolean bool = request.getRequestURI() == "/login.jsp" || request.getRequestURI() == "/login";

            //下面的不是并列关系
            if (request.getRequestURI().equals("/login.jsp") || request.getRequestURI().equals("/login")) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                User loginUser =  (User)request.getSession().getAttribute("loginUser");
                if (loginUser != null) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    response.sendRedirect(request.getContextPath()+"/login.jsp");
                }
            }
    }

    //销毁时调用的方法
    @Override
    public void destroy() {

    }
}