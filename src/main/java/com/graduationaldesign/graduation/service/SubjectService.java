package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Subject;

/**
* @Author: wuzhuhao
* @Date: 2020/1/20 21:10
*/
public interface SubjectService{


int deleteByPrimaryKey(String subId);

int insert(Subject record);

int insertSelective(Subject record);

Subject selectByPrimaryKey(String subId);

int updateByPrimaryKeySelective(Subject record);

int updateByPrimaryKey(Subject record);

}
