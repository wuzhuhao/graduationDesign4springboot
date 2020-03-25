package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Subject;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:10
 */
public interface SubjectService {


    String deleteByPrimaryKey(String subId);

    ResponseEntity<Object> insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(String subId);

    ResponseEntity<Object> updateByPrimaryKeySelective(Subject record);

    ResponseEntity<Object> updateListByPrimaryKeySelective(List<Subject> lstRecord);

    int updateByPrimaryKey(Subject record);

    PageBean<Subject> listByPageOfNotChoice(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageBean<Subject> listByPageOfChoice(HashMap<String, Object> params, int page,
                                         int pageSize, Student student)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageBean<Subject> listByPageOfTea(HashMap<String, Object> params, int page, int pageSize,
                                      Teacher teacher)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageBean<Subject> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    String ChoiceSubject(String subId, Student login_user);

    String cancelChoice(String subId, Student login_user);

    void deleteByPrimaryKeyIn(List<String> lstprimaryKey) throws Exception;

    PageBean<Map<String, Object>> listChoosedByPageOfTea(HashMap<String, Object> params, int page,
                                                         int pageSize, Teacher teacher)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;

    void uploadSubjectFile(MultipartFile file, String subId);
}
