package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.JWT.JWTUtil;
import com.graduationaldesign.graduation.JWT.TokenService;
import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.pojo.UserModel;
import com.graduationaldesign.graduation.service.AdminService;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.service.TeacherService;
import com.graduationaldesign.graduation.util.CookieUtil;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/9 18:28
 */
@Api(Pojo = "SysUser", description = "用户Controller")
@RestController
public class GlobalController {

    private final int STU = 1;
    private final int TEA = 2;
    private final int ADMIN = 3;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    TokenService tokenService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(String number, String password, Integer type)
            throws Exception {
        HttpSession session = request.getSession();
        Object result;
        try {
            if (type.equals(STU)) {
                result = studentService.login(new Student(number, password));
            } else if (type.equals(TEA)) {
                result = teacherService.login(new Teacher(number, password));
            } else if (type.equals(ADMIN)) {
                result = adminService.login(new Admin(number, password));
            } else {
                return ResponseStatus.failure("请选择正确的身份", this);
            }
        } catch (NullPointerException e) {
            return ResponseStatus.failure("请选择登陆身份", this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
        CookieUtil.setCookie(request, response, "token", JWTUtil.createToken(number, type), CookieUtil.COOKIEMAXTIME);
        return ResponseStatus.success(result, this);
    }

    @RequestMapping(value = "/stu/changPassword", method = RequestMethod.POST)
    public ResponseEntity<Object> stuChangePassword(String oldPassword, String newPassword) {
        return ChangePassword(oldPassword, newPassword, STU);
    }

    @RequestMapping(value = "/tea/changPassword", method = RequestMethod.POST)
    public ResponseEntity<Object> teaChangePassword(String oldPassword, String newPassword) {
        return ChangePassword(oldPassword, newPassword, TEA);
    }

    @RequestMapping(value = "/admin/changPassword", method = RequestMethod.POST)
    public ResponseEntity<Object> adminChangePassword(String oldPassword, String newPassword) {
        return ChangePassword(oldPassword, newPassword, ADMIN);
    }

    private ResponseEntity<Object> ChangePassword(String oldPassword, String newPassword,
                                                  Integer type) {
        Object user;
        user = tokenService.getUserByToken(request);
        String userID;
        ResponseEntity<Object> result;
        String message;
        try {
            if (type.equals(1)) {
                /*学生修改密码*/
                userID = ((Student) user).getStuId();
                message = studentService.changPassword(userID, oldPassword, newPassword) == null ? "修改失败" : "修改成功";
            } else if (type.equals(2)) {
                /*教师修改密码*/
                userID = ((Teacher) user).getTeaId();
                message = teacherService.changPassword(userID, oldPassword, newPassword);
            } else if (type.equals(3)) {
                /*管理员修改密码*/
                userID = ((Admin) user).getAdminId();
                message = adminService.changPassword(userID, oldPassword, newPassword);
            } else {
                message = "请求参数不对！";
            }

        } catch (RuntimeException e) {
            message = e.getMessage();
        }
        result = ResponseStatus.success(message, this);
        return result;
    }

    @RequestMapping(value = "/stu/changeInformation", method = RequestMethod.POST)
    public ResponseEntity<Object> stuChangeInformation(UserModel userModel) {
        return changeInformation(userModel, STU);
    }

    @RequestMapping(value = "/tea/changeInformation", method = RequestMethod.POST)
    public ResponseEntity<Object> teaChangeInformation(UserModel userModel) {
        return changeInformation(userModel, TEA);
    }

    @RequestMapping(value = "/admin/changeInformation", method = RequestMethod.POST)
    public ResponseEntity<Object> adminChangeInformation(UserModel userModel) {
        return changeInformation(userModel, ADMIN);
    }

    private ResponseEntity<Object> changeInformation(UserModel userModel, Integer type) {
        Object user;
        user = tokenService.getUserByToken(request);
        String userID;
        ResponseEntity<Object> result;
        String message;
        try {
            if (type.equals(1)) {
                /*学生修改密码*/
                userID = ((Student) user).getStuId();
                userModel.setId(userID);
                message = studentService.changeInformation(userModel);
            } else if (type.equals(2)) {
                /*教师修改密码*/
                userID = ((Teacher) user).getTeaId();
                userModel.setId(userID);
                message = teacherService.changeInformation(userModel);
            } else if (type.equals(3)) {
                /*管理员修改密码*/
                userID = ((Admin) user).getAdminId();
                userModel.setId(userID);
                message = adminService.changeInformation(userModel);
            } else {
                message = "请求参数不对！";
            }
        } catch (RuntimeException e) {
            message = e.getMessage();
        }
        result = ResponseStatus.success(message, this);
        return result;
    }


    /**
     * 退出登陆
     *
     * @return
     */
    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    @CacheEvict(cacheNames = {"student", "teacher", "admin"}, allEntries = true)
    public ResponseEntity<Object> exit() {
        try {
            CookieUtil.deleteCookie(request, response, "token");
            return ResponseStatus.success("退出登陆成功", this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("退出登陆失败", this);
        }
    }
}
