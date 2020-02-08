package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Task;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;

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

    PageBean<Task> listByPageOfTea(HashMap<String, Object> param, int page, int pageSize,
            String teaId);

    PageBean<Task> listByPageOfStu(HashMap<String, Object> param, int page, int pageSize,
            String stuId,
            String type);

    public PageBean<Task> listByPage(HashMap<String, Object> param, int page, int pageSize);
}
