package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Task;
import com.graduationaldesign.graduation.service.SubjectService;
import com.graduationaldesign.graduation.service.TaskService;
import com.graduationaldesign.graduation.util.BeanUtil;
import com.graduationaldesign.graduation.util.FileUtil;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuzhuhao
 * @version $Id: TaskController.java, v 0.1 2020-01-21 10:53:19 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    HttpServletResponse response;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> listByPage(@RequestParam HashMap<String, Object> param,
                                             @RequestParam(required = false, defaultValue = "1") int page,
                                             @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatus
                    .success(taskService.listByPage(param, page, pageSize), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    @RequestMapping(value = "/listByTea/{teaId}", method = RequestMethod.GET)
    public ResponseEntity<Object> listBytea(@RequestParam HashMap<String, Object> param,
                                            @RequestParam(required = false, defaultValue = "1") int page,
                                            @PathVariable(value = "teaId") String teaId,
                                            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        request.getSession().getAttribute("");
        PageBean<Task> object = null;
        try {
            object = taskService
                    .listByPageOfTea(param, page, pageSize, teaId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
        object.setTotalRecord(1);
        object.setPageSize(5);
        return ResponseStatus.success(object, this);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addTask(Task task) {
        return ResponseStatus.success(taskService.insertSelective(task), this);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delTask(Integer id) {
        try {
            return ResponseStatus.success(taskService.deleteByPrimaryKey(id), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> updateTask(Task task) {
        try {
            return ResponseStatus.success(taskService.updateByPrimaryKeySelective(task), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * @param param 查找条件
     * @param page  页数
     * @param stuId 学生id
     * @param type  1是待接任务，2是已接任务
     * @return
     */
    @RequestMapping(value = "/listByStu/{stuId}/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> listByStu(@RequestParam HashMap<String, Object> param
            , @RequestParam(required = false, defaultValue = "1") int page
            , @PathVariable(value = "stuId") String stuId
            , @PathVariable(value = "type") String type,
                                            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            PageBean<Task> object = taskService
                    .listByPageOfStu(param, page, pageSize, stuId, type);
            return ResponseStatus.success(object, this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTaskList(
            @RequestParam(value = "primaryKey") List<Integer> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            taskService.deleteByPrimaryKeyIn(lstprimaryKey);
            result = ResponseStatus.success(
                    MessageFormat.format("批量删除{0}成功", rootPropeties.getAcademy()));
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatus.failure(
                    MessageFormat.format("批量删除{0}失败", rootPropeties.getAcademy()), this);
        }
        return result;
    }

    @RequestMapping(value = "/listUpdate", method = RequestMethod.POST)
    public ResponseEntity<Object> updateTask(@RequestBody List<Task> lstTask) {
        try {
            return taskService.updateListByPrimaryKeySelective(lstTask);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @RequestMapping("/export")
    public void export(Integer primaryKey) {
        Map<String, Object> params;
        Task task = taskService.selectByPrimaryKey(primaryKey);
        params = BeanUtil.beanToMap(task);
        //这里是我说的一行代码
        FileUtil.exportWord("word/task.docx", "/test", "任务书.docx", params, request, response);
    }

//    @RequestMapping("/export")
//    public void export(List<Integer> lstPrimaryKey) {
//        Map<String, Object> params;
//
//        for(Integer primaryKey:lstPrimaryKey){
//            Task task = taskService.selectByPrimaryKey(primaryKey);
//        }
//        params = BeanUtil.beanToMap(task);
//        //这里是我说的一行代码
//        FileUtil.exportWord("word/task.docx", "/test", "任务书.docx", params, request, response);
//    }
}