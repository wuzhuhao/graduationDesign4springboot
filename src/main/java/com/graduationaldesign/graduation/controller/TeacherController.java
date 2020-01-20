package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 14:48
 */
@Controller
@RequestMapping("/tea")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

}
