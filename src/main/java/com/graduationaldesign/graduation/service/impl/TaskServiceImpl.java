package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.TaskMapper;
import com.graduationaldesign.graduation.pojo.Task;
import com.graduationaldesign.graduation.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:10
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return taskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Task record) {
        return taskMapper.insert(record);
    }

    @Override
    public int insertSelective(Task record) {
        return taskMapper.insertSelective(record);
    }

    @Override
    public Task selectByPrimaryKey(Integer id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Task record) {
        return taskMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Task record) {
        return taskMapper.updateByPrimaryKey(record);
    }

}
