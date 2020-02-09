package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
public interface ReportService {

    int deleteByPrimaryKey(String subId, Integer reportType);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(String subId, Integer reportType);

    Report selectById(int reportId);

    String updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);

    PageBean<Report> listByPage(HashMap<String, Object> params, int page, Integer pageSize);

    PageBean<Report> listByPageOfStu(HashMap<String, Object> params, int page, Integer pageSize,
            Student student, int reportType);
}
