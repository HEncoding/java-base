package com.powernode.mapper;

import com.powernode.model.Car;
import com.powernode.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author : HD
 * @create 2021/12/9 15:48
 */
public class CarDao {

    public String insertCar(Car car) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        connection = JDBCUtils.getConnection();
        preparedStatement = connection.prepareStatement("insert into car (c_brand, c_color, c_number, s_size, s_status)VALUES(?, ?, ?, ?, 0);");
        preparedStatement.setString(1,car.getBrand());
        preparedStatement.setString(2,car.getColor());
        preparedStatement.setString(3,car.getNumber());
        preparedStatement.setString(4,car.getSize());
        int i = preparedStatement.executeUpdate();

        JDBCUtils.closeM(connection, preparedStatement, resultSet);
        if (i != -1) {
            return  "success";
        }
        return  "false";
    }

    public ArrayList<Car> selectByList() throws SQLException {
        ArrayList<Car> cars = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = JDBCUtils.getConnection();
        preparedStatement = connection.prepareStatement("select * from car");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getInt("c_id"));
            car.setBrand(resultSet.getString("c_brand"));
            car.setColor(resultSet.getString("c_color"));
            car.setNumber(resultSet.getString("c_number"));
            car.setSize(resultSet.getString("c_size"));
            cars.add(car);
        }
        return cars;
    }

    public ArrayList<Car> selectByList(String brand, String color) throws SQLException {
        ArrayList<Car> cars = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = JDBCUtils.getConnection();
            String sql = "";
            if (brand.equals("") && !color.equals("")){
                 sql = "select from car where c_color = '"+color+"'";
            }else if (!brand.equals("") && color.equals("")){
                 sql = "select from car where c_brand = '"+brand+"'";
            } else if (!brand.equals("") && !color.equals("")) {
                 sql = "select  * from car where c_brand = '"+brand+"' and c_color = '"+color+"'";
            }

        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getInt("c_id"));
            car.setBrand(resultSet.getString("c_brand"));
            car.setColor(resultSet.getString("c_color"));
            car.setNumber(resultSet.getString("c_number"));
            car.setSize(resultSet.getString("c_size"));
            cars.add(car);
        }
        return cars;
    }

    public String deleteById(String id) throws SQLException {
        //
        String isSuccess = "success";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = JDBCUtils.getConnection();

        String sql = "";
            if (id == null) {
                sql = "update car set c_status=1;";
            }else if(!id.equals("")){
                sql = "update car set c_status=1 where c_id="+ id;
            }

        preparedStatement = connection.prepareStatement(sql);
        int i = preparedStatement.executeUpdate();

            if(i == -1) {
                isSuccess = "false";
            }

        return isSuccess;
    }
}
