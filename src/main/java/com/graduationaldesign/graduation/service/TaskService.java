package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Task;

/**
* @Author: wuzhuhao
* @Date: 2020/1/20 21:10
*/
public interface TaskService{


int deleteByPrimaryKey(Integer id);

int insert(Task record);

int insertSelective(Task record);

Task selectByPrimaryKey(Integer id);

int updateByPrimaryKeySelective(Task record);

int updateByPrimaryKey(Task record);

}
