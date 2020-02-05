package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Report;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
public interface ReportService {

    int deleteByPrimaryKey(String subId, Integer reportType);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(String subId, Integer reportType);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);

}
