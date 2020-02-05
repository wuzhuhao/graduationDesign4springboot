package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.GoodGraduation;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
public interface GoodGraduationService {

    int deleteByPrimaryKey(Integer id);

    int insert(GoodGraduation record);

    int insertSelective(GoodGraduation record);

    GoodGraduation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodGraduation record);

    int updateByPrimaryKey(GoodGraduation record);

}
