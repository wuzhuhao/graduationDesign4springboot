package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.DesignShow;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:15
 */
public interface DesignShowService {

    int deleteByPrimaryKey(Integer id);

    int insert(DesignShow record);

    int insertSelective(DesignShow record);

    DesignShow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesignShow record);

    int updateByPrimaryKey(DesignShow record);

}
