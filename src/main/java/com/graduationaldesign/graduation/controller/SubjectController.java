package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.JWT.TokenService;
import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Subject;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.FileDownService;
import com.graduationaldesign.graduation.service.SubjectService;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @author wuzhuhao
 * @version $Id: SubjectController.java, v 0.1 2020-01-21 10:53:08 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/sub")
@Api(Pojo = "Subject", description = "课题表")
public class SubjectController {

    @Autowired
    SubjectService subjectService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    TokenService tokenService;
    @Autowired
    FileDownService fileDownService;

    @RequestMapping(value = "/temp")
    public ResponseEntity<Object> temp() {
        return ResponseStatus.success("退出登陆成功", this);
    }

    /**
     * 增加课题
     *
     * @param subject
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addSubject(Subject subject) {
        try {
            return subjectService.insert(subject);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * 修改课题
     *
     * @param subject
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> updateSubject(Subject subject) {
        try {
            return subjectService.updateByPrimaryKeySelective(subject);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @RequestMapping(value = "/listUpdate", method = RequestMethod.POST)
    public ResponseEntity<Object> updateSubject(@RequestBody List<Subject> lstSubject) {
        try {
            return subjectService.updateListByPrimaryKeySelective(lstSubject);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * 删除课题
     *
     * @param sudId
     * @return
     */
    @RequestMapping(value = "/delete/{sudId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(@PathVariable(value = "sudId") String sudId) {
        try {
            return ResponseStatus.success(subjectService.deleteByPrimaryKey(sudId), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("请求失败", this);
        }
    }

    /**
     * 查看课题详情
     *
     * @param subId
     * @return
     */
    @RequestMapping(value = "/getSubject", method = RequestMethod.GET)
    public ResponseEntity<Object> getSubject(String subId) {
        try {
            return ResponseStatus.success(subjectService.selectByPrimaryKey(subId), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("请求失败", this);
        }
    }

    /**
     * 学生请求选题列表
     *
     * @return
     */
    @RequestMapping(value = "/listOfNotChoice", method = RequestMethod.GET)
    public ResponseEntity<Object> getSubjectOfNotChoice(
            @RequestParam HashMap<String, Object> params,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatus.success(subjectService.listByPageOfNotChoice(params, page, pageSize), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    /**
     * 学生端请求已选题列表
     *
     * @return
     */
    @RequestMapping(value = "/listOfChoice", method = RequestMethod.GET)
    public ResponseEntity<Object> getSubjectOfChoice(@RequestParam HashMap<String, Object> params,
                                                     @RequestParam(required = false, defaultValue = "1") int page,
                                                     @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatus.success(subjectService.listByPageOfChoice(params, page, pageSize, ((Student) tokenService.getUserByToken(request))), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    /**
     * 获取老师的全部选题
     *
     * @return
     */
    @RequestMapping(value = "/listOfTea", method = RequestMethod.GET)
    public ResponseEntity<Object> getSubjectOfTea(@RequestParam HashMap<String, Object> params,
                                                  @RequestParam(required = false, defaultValue = "1") int page,
                                                  @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatus.success(subjectService.listByPageOfTea(params, page, pageSize, ((Teacher) tokenService.getUserByToken(request))), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    /**
     * 获取老师的选题进度
     *
     * @return
     */
    @RequestMapping(value = "/listScheduleOfTea", method = RequestMethod.GET)
    public ResponseEntity<Object> listChoosedByPageOfTea(@RequestParam HashMap<String, Object> params,
                                                         @RequestParam(required = false, defaultValue = "1") int page,
                                                         @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatus.success(subjectService.listChoosedByPageOfTea(params, page, pageSize, ((Teacher) tokenService.getUserByToken(request))), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    /**
     * 管理员获取选题
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params,
                                       @RequestParam(required = false, defaultValue = "1") int page,
                                       @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatus.success(subjectService.listByPage(params, page, pageSize), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    /**
     * 学生选题
     *
     * @param subId
     * @return
     */
    @RequestMapping(value = "/choice", method = RequestMethod.POST)
    public ResponseEntity<Object> choiceSubject(String subId) {
        try {
            return ResponseStatus.success(subjectService.ChoiceSubject(subId,
                    (Student) tokenService.getUserByToken(request)));
        } catch (ClassCastException e) {
            return ResponseStatus.failure("用户异常，请重新登陆", this);
        }
    }

    /**
     * 教师指定选题
     *
     * @param subId
     * @return
     */
    @RequestMapping(value = "/appointChoice", method = RequestMethod.POST)
    public ResponseEntity<Object> appointChoice(String subId, String stuId) {
        try {
            return ResponseStatus.success(subjectService.ChoiceSubject(subId,
                    new Student(stuId, "")));
        } catch (ClassCastException e) {
            return ResponseStatus.failure("用户异常，请重新登陆", this);
        }
    }

    /**
     * 学生取消选题
     *
     * @param subId
     * @return
     */
    @RequestMapping(value = "/cancelChoice", method = RequestMethod.POST)
    public ResponseEntity<Object> cancelChoice(String subId) {
        try {
            return ResponseStatus.success(subjectService.cancelChoice(subId,
                    (Student) tokenService.getUserByToken(request)));
        } catch (ClassCastException e) {
            return ResponseStatus.failure("用户异常，请重新登陆", this);
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubjectList(
            @RequestParam(value = "primaryKey") List<String> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            subjectService.deleteByPrimaryKeyIn(lstprimaryKey);
            result = ResponseStatus.success(
                    MessageFormat.format("批量删除{0}成功", rootPropeties.getAcademy()));
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatus.failure(
                    MessageFormat.format("批量删除{0}失败", rootPropeties.getAcademy()), this);
        }
        return result;
    }

    @RequestMapping(value = "/uploadSubjectFile", method = RequestMethod.POST)
    public ResponseEntity<Object> uploadSubjectFile(@RequestParam("file") MultipartFile file, String subId) {
        try {
            subjectService.uploadSubjectFile(file, subId);
            return ResponseStatus.success("上传附件成功", this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @RequestMapping(value = "/confirmScore", method = RequestMethod.POST)
    public ResponseEntity<Object> confirmScore(String subId) {
        try {
            return ResponseStatus.success(subjectService.confirmScore(subId), this);
        } catch (RuntimeException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }
}