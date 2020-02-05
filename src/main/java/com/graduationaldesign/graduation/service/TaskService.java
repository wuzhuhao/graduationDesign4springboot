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

    PageBean<Task> listByTeaWithPage(HashMap<String, Object> param, int page, String teaId);

    PageBean<Task> listByStuPage(HashMap<String, Object> param, int page, String stuId,
            String type);
}
