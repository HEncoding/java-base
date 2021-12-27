package com.powernode.service;

import com.powernode.mapper.CarMapper;
import com.powernode.model.Car;
import com.powernode.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : HD
 * @create 2021/12/12 20:20
 */
public class CarServiceM {
    private SqlSession sqlSession = MybatisUtil.getSqlSession();
    private CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
    private int i;
    private String isSuccess = "success";

    public String removeByIdM(List<Integer> list) {

        if (list.isEmpty()) {
            i = carMapper.updateByIdAll();
        } else if (!list.isEmpty()) {
            i = carMapper.updateByIdList(list);
        }

        sqlSession.commit();
        MybatisUtil.close();

        if (i == 0) {
            isSuccess = "false";
        }

        return isSuccess;
    }

    /*public ArrayList<Car> getByList() {

    }*/
}
