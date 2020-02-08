package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.util.ResponseStatu;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/getStuById", method = RequestMethod.GET)
    public ResponseEntity<Object> getStuById(String stuId) {
        Student student = studentService.getStuById(stuId);
        if (student == null) {
            return ResponseStatu.failure("该学生不存在");
        }
        return ResponseStatu.success(student);
    }

}
