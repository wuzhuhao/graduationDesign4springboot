package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Progress;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
public interface ProgressService {

    String deleteByPrimaryKey(Integer id);

    int insert(Progress record);

    String insertSelective(Progress record);

    Progress selectByPrimaryKey(Integer id);

    String updateByPrimaryKeySelective(Progress record);

    String reply(Progress record);

    int updateByPrimaryKey(Progress record);

    PageBean<Progress> listByPage(HashMap<String, Object> params, int page, Integer pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;

    PageBean<Progress> listByPageOfStu(HashMap<String, Object> params, int page, Integer pageSize,
                                       Student student)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageBean<Progress> listByPageOfTea(HashMap<String, Object> params, int page, Integer pageSize,
                                       Teacher teacher)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    void deleteByPrimaryKeyIn(List<Integer> lstprimaryKey) throws Exception;

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Progress> lstRecord);

}
