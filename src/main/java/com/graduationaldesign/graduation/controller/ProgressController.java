package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.JWT.TokenService;
import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Progress;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.ProgressService;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author wuzhuhao
 * @version $Id: ProgressController.java, v 0.1 2020-01-21 10:51:59 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/progress")
public class ProgressController {

    @Autowired
    ProgressService progressService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    TokenService tokenService;

    //    @RequestMapping(value="/temp")
    public ResponseEntity<Object> temp() {
        return ResponseStatus.success("退出登陆成功", this);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(Progress progress) {
        progress.setProgContentTime(new Date());
        try {
            return ResponseStatus.success(progressService.insertSelective(progress), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * 获取开题报告或者定稿报告的详情
     *
     * @param progressId 问题id
     * @return
     */
    @RequestMapping(value = "/getDetail/{progressId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable int progressId) {
        try {
            return ResponseStatus.success(progressService.selectByPrimaryKey(progressId), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * 修改问题
     *
     * @param progress
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(Progress progress) {

        try {
            return ResponseStatus.success(progressService.updateByPrimaryKeySelective(progress), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public ResponseEntity<Object> reply(Progress progress) {
        try {
            return ResponseStatus.success(progressService.reply(progress), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(Integer processId) {
        try {
            return ResponseStatus.success(progressService.deleteByPrimaryKey(processId), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * 管理员获取问题
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params,
                                       @RequestParam(required = false, defaultValue = "1") int page,
                                       @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatus
                    .success(progressService
                            .listByPage(params, page, pageSize), this);
        } catch (Exception e) {
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    /**
     * 学生端请求问题列表
     *
     * @return
     */
    @RequestMapping(value = "/listOfStu", method = RequestMethod.GET)
    public ResponseEntity<Object> listOfStu(@RequestParam HashMap<String, Object> params,
                                            @RequestParam(required = false, defaultValue = "1") int page, String stuId,
                                            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        Student student;
        try {
            student = (Student) tokenService.getUserByToken(request);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("登陆身份不对", this);
        }
        student = new Student();
        student.setStuId(stuId);
        try {
            return ResponseStatus.success(progressService.listByPageOfStu(params, page, pageSize, student), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    /**
     * 获取老师的全部问题
     *
     * @return
     */
    @RequestMapping(value = "/listOfTea", method = RequestMethod.GET)
    public ResponseEntity<Object> listOfTea(@RequestParam HashMap<String, Object> params,
                                            @RequestParam(required = false, defaultValue = "1") int page, String teaId,
                                            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        Teacher teacher;
        try {
            teacher = (Teacher) tokenService.getUserByToken(request);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("登陆身份不对", this);
        }
        teacher = new Teacher();
        teacher.setTeaId(teaId);
        try {
            return ResponseStatus.success(progressService.listByPageOfTea(params, page, pageSize, teacher), this);
        } catch (Exception e) {
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProgressList(
            @RequestParam(value = "primaryKey") List<Integer> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            progressService.deleteByPrimaryKeyIn(lstprimaryKey);
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
    public ResponseEntity<Object> updateProgress(@RequestBody List<Progress> lstProgress) {
        try {
            return progressService.updateListByPrimaryKeySelective(lstProgress);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

}