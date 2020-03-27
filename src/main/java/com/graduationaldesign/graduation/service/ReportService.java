package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

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

    String updateByPrimaryKeySelectiveWithStudent(Report record) throws Exception;

    int updateByPrimaryKey(Report record);

    PageBean<Report> listByPage(HashMap<String, Object> params, int page, Integer pageSize,
                                int reportType)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;

    PageBean<Report> listByPageOfStu(HashMap<String, Object> params, int page, Integer pageSize,
                                     Student student, int reportType)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageBean<Report> listByPageOfTea(HashMap<String, Object> params, int page, Integer pageSize,
                                     Teacher teacher, int reportType)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    void deleteByPrimaryKeyIn(List<Integer> lstprimaryKey) throws Exception;

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Report> lstRecord);

    public void uploadFile(MultipartFile file, String subId, Integer type, boolean isTemp);

    public void export(HttpServletRequest request, HttpServletResponse response, String subId, Integer type);
}
