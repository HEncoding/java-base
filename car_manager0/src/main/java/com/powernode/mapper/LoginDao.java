package com.powernode.mapper;

import com.powernode.model.User;
import com.powernode.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author : HD
 * @create 2021/12/7 21:19
 */
public class LoginDao {

    public User login(User user) {
        /**
         * 从数据库里面查询数据
         * 获得结果集，没有查到结果，返回空
         * 如果查询到结果，说明用户验证成功
         * 把查询到的值重新赋值给传过来的对象
         * 关闭资源
         * 返回对象
         * */
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from t_user where loginName = ? and loginPwd = ?");
            //从模型中取出数据
          preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
            //result结果集是个什么东西
            boolean next = resultSet.next();
            if (!next) {
                return null;
            }

            //由于是一个结果集，.next指针下移，return被迫放到里面，导致循环只能执行一次
            while (next) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("loginName"));
                user.setPassword(resultSet.getString("loginPwd"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeM(connection, preparedStatement, resultSet);
        }

        return user;
    }

}
