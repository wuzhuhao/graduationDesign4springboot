package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Task;
import com.graduationaldesign.graduation.service.SubjectService;
import com.graduationaldesign.graduation.service.TaskService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatu;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuzhuhao
 * @version $Id: TaskController.java, v 0.1 2020-01-21 10:53:19 wuzhuhao Exp $$
 */
@Controller
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

    //    @RequestMapping(value="/temp")
    public ResponseEntity<Object> temp() {
        request.getSession().removeAttribute(rootPropeties.getUserAttribute());
        return ResponseStatu.success("退出登陆成功");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> listByPage(@RequestParam HashMap<String, Object> param,
            int page) {
        return ResponseStatu
                .success(taskService.listByPage(param, page, rootPropeties.getPageSize()));
    }

    @RequestMapping(value = "/listBytea/{teaId}", method = RequestMethod.GET)
    public ResponseEntity<Object> listBytea(@RequestParam HashMap<String, Object> param, int page,
            @PathVariable(value = "teaId") String teaId) {
        request.getSession().getAttribute("");
        PageBean<Task> object = taskService
                .listByPageOfTea(param, page, rootPropeties.getPageSize(), teaId);
        object.setTotalRecord(1);
        object.setPageSize(5);
        return ResponseStatu.success(object);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addTask(Task task) {
        return ResponseStatu.success(taskService.insertSelective(task));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delTask(Integer id) {
        try {
            return ResponseStatu.success(taskService.deleteByPrimaryKey(id));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTask(Task task) {
        try {
            return ResponseStatu.success(taskService.updateByPrimaryKeySelective(task));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
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
            , int page
            , @PathVariable(value = "stuId") String stuId
            , @PathVariable(value = "type") String type) {
        try {
            PageBean<Task> object = taskService
                    .listByPageOfStu(param, page, rootPropeties.getPageSize(), stuId, type);
            return ResponseStatu.success(object);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure(e.getMessage());
        }
    }
}