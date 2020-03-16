package com.graduationaldesign.graduation.JWT;

import com.graduationaldesign.graduation.service.AdminService;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.service.TeacherService;
import com.graduationaldesign.graduation.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: wuzhuhao
 * @Date: 2020/3/1 16:30
 */
@Service
public class TokenService {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AdminService adminService;

    public boolean checkUser(String token) throws Exception {
        Map<String, Object> tokenMap = JWTUtil.getUserId(token);
        Integer type = (Integer) tokenMap.get("type");
        String number = (String) tokenMap.get("number");
        boolean flag = false;
        try {
            if (type.equals(1)) {
                Optional.of(studentService.findById(number));
            } else if (type.equals(2)) {
                Optional.of(teacherService.findById(number));
            } else if (type.equals(3)) {
                Optional.of(adminService.findById(number));
            } else {
                return flag;
            }
            flag = true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public Object getUserBytoken(String token) {
        Map<String, Object> tokenMap = JWTUtil.getUserId(token);
        Integer type = (Integer) tokenMap.get("type");
        String number = (String) tokenMap.get("number");
        Object user = null;
        if (type.equals(1)) {
            user = studentService.findById(number);
        } else if (type.equals(2)) {
            user = teacherService.findById(number);
        } else if (type.equals(3)) {
            user = adminService.findById(number);
        }
        return user;
    }

    public Object getUserByToken(HttpServletRequest request) {
        String token = CookieUtil.getCookieValue(request, "token");
        return getUserBytoken(token);
    }
}
