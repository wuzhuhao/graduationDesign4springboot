package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Progress;

/**
* @Author: wuzhuhao
* @Date: 2020/1/20 21:09
*/
public interface ProgressService{


int deleteByPrimaryKey(Integer id);

int insert(Progress record);

int insertSelective(Progress record);

Progress selectByPrimaryKey(Integer id);

int updateByPrimaryKeySelective(Progress record);

int updateByPrimaryKey(Progress record);

}
