package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.pojo.UserModel;
import com.graduationaldesign.graduation.util.PageBean;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/15 0:49
 */
public interface TeacherService {

    Teacher login(Teacher teacher);

    String changPassword(String id, String oldPassword, String newPassword);

    String changeInformation(UserModel userModel);

    int deleteByPrimaryKey(String teaId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String teaId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    PageBean<Teacher> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;

    Teacher findById(String number);

    void insertListSelective(List<Teacher> lstTeacher) throws Exception;
}
