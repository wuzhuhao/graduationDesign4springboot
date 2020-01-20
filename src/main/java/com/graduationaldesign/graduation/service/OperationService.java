package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Operation;

/**
* @Author: wuzhuhao
* @Date: 2020/1/20 21:11
*/
public interface OperationService{


int deleteByPrimaryKey(Integer id);

int insert(Operation record);

int insertSelective(Operation record);

Operation selectByPrimaryKey(Integer id);

int updateByPrimaryKeySelective(Operation record);

int updateByPrimaryKey(Operation record);

}
