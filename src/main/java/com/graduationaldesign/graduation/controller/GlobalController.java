package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.AdminService;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.service.TeacherService;
import com.graduationaldesign.graduation.service.impl.AdminServiceImpl;
import com.graduationaldesign.graduation.service.impl.StudentServiceImpl;
import com.graduationaldesign.graduation.service.impl.TeacherServiceImpl;
import com.graduationaldesign.graduation.util.Result;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/9 18:28
 */
@Controller
public class GlobalController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    HttpServletRequest request;
    @RequestMapping(value="/login" ,produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity<Object> login(String number,String password,Integer type,Model model){
        Map<String, Object> map = model.asMap();
        System.out.println(map);
        HttpSession session = request.getSession();
        Object result = null;
        if (type==1){
            try {
                result = studentService.login(new Student(number,password));

            }catch (RuntimeException e){
                return ResponseEntity.status(HttpStatus.SC_OK).body(Result.failure(e.getMessage()));
            }
        }else if(type==2){
            try {
                result = teacherService.login(new Teacher(number,password));
            }catch (RuntimeException e){
                return ResponseEntity.status(HttpStatus.SC_OK).body(Result.failure(e.getMessage()));
            }
        }
        else if(type==3){
            try {
                result = adminService.login(new Admin(number,password));
            }catch (RuntimeException e){
                return ResponseEntity.status(HttpStatus.SC_OK).body(Result.failure(e.getMessage()));
            }
        }
        else {
            return ResponseEntity.status(HttpStatus.SC_OK).body(Result.failure("请选择正确的身份"));
        }
        session.setAttribute("LOGIN_USER",result);
        return ResponseEntity.status(HttpStatus.SC_OK).body(Result.success(result));
    }
//    @RequestMapping("/login")
    public String loginForward(){
        return "login";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        if (true){
            throw new RuntimeException("错了啊啊啊");
        }
        return "Hello Spring Boot!";
    }

    @RequestMapping(value="/exit")
    public ResponseEntity<Object> exit(){
        request.getSession().removeAttribute("LOGIN_USER");
        return ResponseEntity.status(HttpStatus.SC_OK).body(Result.success("退出登陆成功"));
    }
}
