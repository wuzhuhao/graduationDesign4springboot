package com.graduationaldesign.graduation.mapper;

import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/3/30 0030 22:36
 */
public interface Mapper<T, E> {
    /**
     * @param example
     * @return
     */
    List<T> selectByExample(E example);

    int insertBatchSelective(List<T> tList);
}
