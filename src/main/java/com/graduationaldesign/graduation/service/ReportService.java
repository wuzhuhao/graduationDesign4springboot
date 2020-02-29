package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.util.PageBean;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
public interface ReportService {

    int deleteByPrimaryKey(String subId, Integer reportType);

    String deleteById(Integer reportId);

    String insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(String subId, Integer reportType);

    Report selectById(int reportId);

    String updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);

    PageBean<Report> listByPage(HashMap<String, Object> params, int page, Integer pageSize,
            int reportType)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageBean<Report> listByPageOfStu(HashMap<String, Object> params, int page, Integer pageSize,
            Student student, int reportType)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageBean<Report> listByPageOfTea(HashMap<String, Object> params, int page, Integer pageSize,
            Teacher teacher, int reportType)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
