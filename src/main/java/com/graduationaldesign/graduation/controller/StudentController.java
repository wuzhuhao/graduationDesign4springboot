package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.service.impl.StudentServiceImpl;
import com.graduationaldesign.graduation.util.ResponseStatu;
import com.graduationaldesign.graduation.util.Result;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 19:41
 */
@Controller
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    HttpServletRequest request;


}
