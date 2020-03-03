package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Task;
import com.graduationaldesign.graduation.util.PageBean;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:10
 */
public interface TaskService {

    String deleteByPrimaryKey(Integer id);

    int insert(Task record);

    String insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    String updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    PageBean<Task> listByPageOfTea(HashMap<String, Object> params, int page, int pageSize,
            String teaId)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    PageBean<Task> listByPageOfStu(HashMap<String, Object> params, int page, int pageSize,
            String stuId,
            String type)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    public PageBean<Task> listByPage(HashMap<String, Object> param, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    void deleteByPrimaryKeyIn(List<Integer> lstprimaryKey) throws Exception;
}
