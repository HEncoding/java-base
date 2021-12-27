package com.powernode.service;

import com.powernode.mapper.CarDao;
import com.powernode.model.Car;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author : HD
 * @create 2021/12/9 15:48
 */
public class CarService {
    private CarDao carDao = new CarDao();

    public String addCar(Car car) throws SQLException {
        return carDao.insertCar(car);
    }

    public ArrayList<Car> getByList() throws SQLException {
        return carDao.selectByList();
    }

    public ArrayList<Car> findByList(String brand, String color) throws SQLException {
        return carDao.selectByList(brand, color);
    }

    public String removeById(String id) throws SQLException {
       return carDao.deleteById(id);
    }
}
