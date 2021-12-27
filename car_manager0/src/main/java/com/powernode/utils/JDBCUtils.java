package com.powernode.utils;

import java.sql.*;

/**
 * @Author : HD
 * @create 2021/12/7 22:23
 */
public class JDBCUtils {
    //准备获取连接的参数   可以从xml配置文件里面获取，也可以直接写上
    //静态代码块里面封装公共的资源
    //封装获取连接的方法
    //封装关闭资源的方法和回滚方法
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String URL="jdbc:mysql://localhost:3307/mysqltest?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  static Connection getConnection() throws SQLException {
         connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return  connection;
    }

    public static void startTransaction(){
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public  static  void  rollbackTransaction(){
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public  static  void  commitTransaction(){
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public  static void  closeM(Connection conn, Statement stat, ResultSet rst) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (rst != null) {
            try {
                rst.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
