package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.TaskMapper;
import com.graduationaldesign.graduation.pojo.Task;
import com.graduationaldesign.graduation.pojo.TaskExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.TaskService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:10
 */
@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Autowired
    RootPropeties rootPropeties;

    /*==============私有接口=====================*/

    /*==============公开接口=====================*/
    @Override
    public String deleteByPrimaryKey(Integer id) throws RuntimeException {
        String message = "删除任务成功";
        if (taskMapper.deleteByPrimaryKey(id) < 0) {
            throw new RuntimeException("删除任务失败");
        }
        return "删除任务成功";
    }

    @Override
    public int insert(Task record) {
        return taskMapper.insert(record);
    }

    @Override
    public String insertSelective(Task record) throws RuntimeException {
        String message = "创建任务成功";
        record.setTaskState("1");
        record.setTaskTime(new Date());
        if (taskMapper.insertSelective(record) <= 0) {
            throw new RuntimeException("创建任务失败");
        }
        return message;
    }

    @Override
    public Task selectByPrimaryKey(Integer id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public String updateByPrimaryKeySelective(Task record) throws RuntimeException {
        if (taskMapper.updateByPrimaryKeySelective(record) <= 0) {
            throw new RuntimeException("修改任务失败");
        }
        return "修改任务成功";
    }

    @Override
    public int updateByPrimaryKey(Task record) {
        return taskMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<Task> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<Task> pageBean = new PageBean<>();
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        ExampleHelper.addCondition(Task.class, criteria, params);
//        if (DataConvertUtil.strToBoolean(DataConvertUtil.objToStr(params.get("isJoinSubject")))) {
//            taskExample.setJoin(" left join t_subject on t_subject.sub_id = t_task.task_sub_id ");
//            ExampleHelper.addJoinCondition(Subject.class, criteria, params);
//        }
        ExampleHelper.searchJoin(Task.class, taskExample, criteria, params);
        List<Task> list = taskMapper.selectByExampleWithBLOBs(taskExample);
        pageBean.setBeanList(list);
        for (Task task : list) {
            task.getSubject();
            task.getSubject().getStudent();
            task.getSubject().getTeacher();
        }
//        pageBean.setParams();
        return pageBean;
    }

    //listByTeaWithPage listByPageOfTea
    @Override
    public PageBean<Task> listByPageOfTea(HashMap<String, Object> params, int page, int pageSize,
                                          String teaId)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TaskExample taskExample = new TaskExample();
        taskExample.setJoin("left join t_subject on t_task.task_sub_id = t_subject.sub_id");
        TaskExample.Criteria criteria = taskExample.createCriteria();
        ExampleHelper.addCondition(Task.class, criteria, params);
        criteria.andJoinTeaIdEqualTo(teaId);
        List<Task> taskList = taskMapper.selectByExampleWithBLOBs(taskExample);
        PageBean<Task> pageBean = new PageBean<>();
        for (Task task : taskList) {
            task.getSubject();
            task.getSubject().getStudent();
            task.getSubject().getTeacher();
        }
        pageBean.setBeanList(taskList);
        return pageBean;
    }

    @Override
    public PageBean<Task> listByPageOfStu(HashMap<String, Object> params, int page, int pageSize,
                                          String stuId,
                                          String type)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (!(type.equals("1") || type.equals("2"))) {
            throw new RuntimeException("type参数错误");
        }
        PageBean<Task> pageBean = new PageBean<>();
        TaskExample taskExample = new TaskExample();
        taskExample.setJoin("left join t_subject on t_task.task_sub_id = t_subject.sub_id");
        TaskExample.Criteria criteria = taskExample.createCriteria();
        ExampleHelper.addCondition(Task.class, criteria, params);
        criteria.andJoinStuIdEqualTo(stuId);
        criteria.andTaskStateEqualTo(type);
        List<Task> list = taskMapper.selectByExampleWithBLOBs(taskExample);
        for (Task task : list) {
            task.getSubject();
            task.getSubject().getStudent();
            task.getSubject().getTeacher();
        }
        pageBean.setBeanList(list);
        return pageBean;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        TaskExample example = new TaskExample();
        TaskExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        taskMapper.deleteByExample(example);
    }

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Task> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getTask());
        try {
            taskMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getTask());
        }
        return ResponseStatus.success(message);
    }
}
