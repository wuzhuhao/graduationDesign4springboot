package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Subject;

/**
* @Author: wuzhuhao
* @Date: 2020/1/20 21:10
*/
public interface SubjectService{


String deleteByPrimaryKey(String subId);

String insert(Subject record);

int insertSelective(Subject record);

Subject selectByPrimaryKey(String subId);

String updateByPrimaryKeySelective(Subject record);

int updateByPrimaryKey(Subject record);

}
