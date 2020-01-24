package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.pojo.UserModel;
import com.graduationaldesign.graduation.service.AdminService;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.service.TeacherService;
import com.graduationaldesign.graduation.service.impl.AdminServiceImpl;
import com.graduationaldesign.graduation.service.impl.StudentServiceImpl;
import com.graduationaldesign.graduation.service.impl.TeacherServiceImpl;
import com.graduationaldesign.graduation.util.ResponseStatu;
import com.graduationaldesign.graduation.util.Result;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    private final int STU = 1;
    private final int TEA = 2;
    private final int ADMIN = 3;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    HttpServletRequest request;
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> login(String number,String password,Integer type){
        HttpSession session = request.getSession();
        Object result;
        try {
            if (type.equals(STU)){
                result = studentService.login(new Student(number,password));
            }else if(type.equals(TEA)){
                result = teacherService.login(new Teacher(number,password));
            }
            else if(type.equals(ADMIN)){
                result = adminService.login(new Admin(number,password));
            }
            else {
                return ResponseStatu.failure("请选择正确的身份");
            }
        } catch (NullPointerException e) {
            return ResponseStatu.failure("请选择登陆身份");
        } catch (RuntimeException e){
            return ResponseStatu.failure(e.getMessage());
        }
        session.setAttribute("LOGIN_USER",result);
        return ResponseStatu.success(result);
    }
    @RequestMapping(value="/stu/changPassword",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> stuChangPassword(String oldPassword,String newPassword){
        return changPassword(oldPassword,newPassword,STU);
    }
    @RequestMapping(value="/tea/changPassword",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> teaChangPassword(String oldPassword,String newPassword){
        return changPassword(oldPassword,newPassword,TEA);
    }

    @RequestMapping(value="/admin/changPassword",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> adminChangPassword(String oldPassword,String newPassword){
        return changPassword(oldPassword,newPassword,ADMIN);
    }

    private ResponseEntity<Object> changPassword(String oldPassword,String newPassword,Integer type){
        Object user;
        user = request.getSession().getAttribute("LOGIN_USER");
        String userID;
        ResponseEntity<Object> result;
        String message;
        try {
            if (type.equals(1)){
            /*学生修改密码*/
                userID = ((Student)user).getStuId();
                message = studentService.changPassword(userID,oldPassword,newPassword);
            }else if(type.equals(2)){
            /*教师修改密码*/
                userID = ((Teacher)user).getTeaId();
                message = teacherService.changPassword(userID,oldPassword,newPassword);
            }else if(type.equals(3)){
            /*管理员修改密码*/
                userID = ((Admin)user).getAdminId();
                message = adminService.changPassword(userID,oldPassword,newPassword);
            }else{
                message = "请求参数不对！";
            }

        }catch (RuntimeException e){
            message = e.getMessage();
        }
        result = ResponseStatu.success(message);
        return result;
    }
    @RequestMapping(value = "/stu/changeInformation",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> stuChangeInformation(UserModel userModel){
        return changeInformation(userModel,STU);
    }

    @RequestMapping(value = "/tea/changeInformation",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> teaChangeInformation(UserModel userModel){
        return changeInformation(userModel,TEA);
    }

    @RequestMapping(value = "/admin/changeInformation",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> adminChangeInformation(UserModel userModel){
        return changeInformation(userModel,ADMIN);
    }

    private ResponseEntity<Object> changeInformation(UserModel userModel,Integer type){
        Object user;
        user = request.getSession().getAttribute("LOGIN_USER");
        String userID;
        ResponseEntity<Object> result;
        String message;
        try {
            if (type.equals(1)){
            /*学生修改密码*/
                userID = ((Student)user).getStuId();
                userModel.setId(userID);
                message = studentService.changeInformation(userModel);
            }else if(type.equals(2)){
            /*教师修改密码*/
                userID = ((Teacher)user).getTeaId();
                userModel.setId(userID);
                message = teacherService.changeInformation(userModel);
            }else if(type.equals(3)){
            /*管理员修改密码*/
                userID = ((Admin)user).getAdminId();
                userModel.setId(userID);
                message = adminService.changeInformation(userModel);
            }else{
                message = "请求参数不对！";
            }
        }catch (RuntimeException e){
            message = e.getMessage();
        }
        result = ResponseStatu.success(message);
        return result;
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

    @RequestMapping(value="/exit",method = RequestMethod.GET)
    public ResponseEntity<Object> exit(){
        request.getSession().removeAttribute("LOGIN_USER");
        return ResponseStatu.success("退出登陆成功");
    }
}
