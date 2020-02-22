package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.util.ResponseStatu;
import java.text.MessageFormat;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 19:41
 */
@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;

    @RequestMapping(value = "/getStuById", method = RequestMethod.GET)
    public ResponseEntity<Object> getStuById(String stuId) {
        Student student = studentService.getStuById(stuId);
        if (student == null) {
            return ResponseStatu.failure("该学生不存在");
        }
        return ResponseStatu.success(student);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(Student record) {
        ResponseEntity<Object> result = null;
        if (studentService.insertSelective(record) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("添加{0}失败", rootPropeties.getStudent()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("添加{0}成功", rootPropeties.getStudent()));
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(Student record) {
        ResponseEntity<Object> result = null;
        if (studentService.updateByPrimaryKeySelective(record) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("修改{0}失败", rootPropeties.getStudent()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("修改{0}成功", rootPropeties.getStudent()));
        }
        return result;

    }

    @RequestMapping(value = "/delete/{primaryKey}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(
            @PathVariable(value = "primaryKey") String primaryKey) {
        ResponseEntity<Object> result = null;
        if (studentService.deleteByPrimaryKey(primaryKey) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("删除{0}失败", rootPropeties.getStudent()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("删除{0}成功", rootPropeties.getStudent()));
        }
        return result;
    }

    @RequestMapping(value = "/getDetail/{primaryKey}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable(value = "primaryKey") String primaryKey) {
        ResponseEntity<Object> result = null;
        Student record = studentService.selectByPrimaryKey(primaryKey);
        if (record == null) {
            result = ResponseStatu.failure(
                    MessageFormat.format("该{0}不存在", rootPropeties.getStudent()));
        } else {
            result = ResponseStatu.success(record);
        }
        return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params, int page) {
        return ResponseStatu
                .success(studentService.listByPage(params, page, rootPropeties.getPageSize()));
    }

}
