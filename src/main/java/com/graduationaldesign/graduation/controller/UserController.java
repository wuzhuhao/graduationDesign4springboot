package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.pojo.User;
import com.graduationaldesign.graduation.service.UserService;
import com.graduationaldesign.graduation.util.ResponseStatus;
import com.graduationaldesign.graduation.util.Result;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/user/{userid}")
    @ResponseBody
    public User getUserById(@PathVariable Integer userid){
        User user = userService.getUserById(userid);
        return  user;
    }
    @RequestMapping(value="/login.do" , method= RequestMethod.POST)
    @ResponseBody
    public Result login(User userParam){
        HttpSession session = request.getSession();
        User user = userService.login(userParam.getUserName(),userParam.getPasswd());
        if (user==null){
            return Result.failure("登陆失败，请检查账号密码");
        }else {
            session.setAttribute("LOGIN_USER",user);
            return Result.success(user);
        }
    }

    @RequestMapping(value="/register.do" , method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity<Object> register(User userParam){
        boolean re = userService.register(userParam);
        if (!re){
            return ResponseStatus.response(HttpStatus.SC_OK,Result.failure("注册失败，账号已存在，请检查账号信息！"));
        }else {
            return ResponseEntity.status(HttpStatus.SC_OK).body(Result.success("注册成功,可以登陆啦！",null));
        }
    }

    @RequestMapping(value="/exit")
    public String exit(){
        request.getSession().removeAttribute("LOGIN_USER");
        return "login";
    }
}
