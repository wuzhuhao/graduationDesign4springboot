package com.graduationaldesign.graduation.service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/4/5 0005 16:32
 */
public interface CurdService<T> {
    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
