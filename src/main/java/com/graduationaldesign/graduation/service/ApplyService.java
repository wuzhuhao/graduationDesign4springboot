package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Apply;

/**
* @Author: wuzhuhao
* @Date: 2020/1/20 21:05
*/
public interface ApplyService{


int deleteByPrimaryKey(Integer id);

int insert(Apply record);

int insertSelective(Apply record);

Apply selectByPrimaryKey(Integer id);

int updateByPrimaryKeySelective(Apply record);

int updateByPrimaryKey(Apply record);

}
