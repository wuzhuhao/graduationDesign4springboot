package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 20:35
 */
@Controller
public class AcademyController {

    @Autowired
    private StudentService studentService;

}
