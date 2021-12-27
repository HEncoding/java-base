package com.powernode.mapper;

import java.util.List;

/**
 * @Author : HD
 * @create 2021/12/12 20:04
 */
public interface CarMapper {

    int updateByIdList(List<Integer> list);

    int updateByIdAll();
}
