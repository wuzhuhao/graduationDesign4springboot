package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.UserModel;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 19:32
 */
public interface StudentService extends CurdService<Student> {

    Student login(Student student);

    Student changPassword(String id, String oldPassword, String newPassword);

    String changeInformation(UserModel userModel);

    Student findById(String id);

    int deleteByPrimaryKey(String stuId);

    int insert(Student record);

    int insertSelective(Student record);

    void insertListSelective(List<Student> lstStudent) throws Exception;

    Student selectByPrimaryKey(String stuId);

//    int updateByPrimaryKeySelective(Student record);
//
//    int updateByPrimaryKey(Student record);

    PageBean<Student> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;

    void deleteByPrimaryKeyIn(List<String> lstprimaryKey) throws Exception;

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Student> lstRecord);

}
