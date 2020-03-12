package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.JWT.TokenService;
import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Progress;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.ProgressService;
import com.graduationaldesign.graduation.util.ResponseStatu;
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
        return ResponseStatu.success("退出登陆成功");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(Progress progress) {
        progress.setProgContentTime(new Date());
        try {
            return ResponseStatu.success(progressService.insertSelective(progress));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
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
            return ResponseStatu.success(progressService.selectByPrimaryKey(progressId));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

    /**
     * 修改问题
     *
     * @param progress
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(Progress progress) {

        try {
            return ResponseStatu.success(progressService.updateByPrimaryKeySelective(progress));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/reply", method = RequestMethod.PUT)
    public ResponseEntity<Object> reply(Progress progress) {
        try {
            return ResponseStatu.success(progressService.reply(progress));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(Integer processId) {
        try {
            return ResponseStatu.success(progressService.deleteByPrimaryKey(processId));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
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
            return ResponseStatu
                    .success(progressService
                            .listByPage(params, page, pageSize));
        } catch (Exception e) {
            return ResponseStatu.failure("获取列表失败");
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
            return ResponseStatu.failure("登陆身份不对");
        }
        student = new Student();
        student.setStuId(stuId);
        try {
            return ResponseStatu.success(progressService.listByPageOfStu(params, page,
                    pageSize
                    , student));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("获取列表失败");
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
            return ResponseStatu.failure("登陆身份不对");
        }
        teacher = new Teacher();
        teacher.setTeaId(teaId);
        try {
            return ResponseStatu.success(progressService.listByPageOfTea(params, page,
                    pageSize,
                    teacher));
        } catch (Exception e) {
            return ResponseStatu.failure("获取列表失败");
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProgressList(
            @RequestParam(value = "primaryKey") List<Integer> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            progressService.deleteByPrimaryKeyIn(lstprimaryKey);
            result = ResponseStatu.success(
                    MessageFormat.format("批量删除{0}成功", rootPropeties.getAcademy()));
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatu.failure(
                    MessageFormat.format("批量删除{0}失败", rootPropeties.getAcademy()));
        }
        return result;
    }

    @RequestMapping(value = "/listUpdate", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProgress(List<Progress> lstProgress) {
        try {
            return progressService.updateListByPrimaryKeySelective(lstProgress);
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

}