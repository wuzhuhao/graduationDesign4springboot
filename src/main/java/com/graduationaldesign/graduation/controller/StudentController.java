package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.util.Result;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 19:41
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(value="/login" ,produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity<Object> login(Student student){
        try {
            return ResponseEntity.status(HttpStatus.SC_OK).body(Result.success(studentService.login(student)));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.SC_OK).body(Result.failure(e.getMessage()));
        }
    }
}
