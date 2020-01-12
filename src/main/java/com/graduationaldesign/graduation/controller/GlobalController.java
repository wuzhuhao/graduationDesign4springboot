package com.graduationaldesign.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/9 18:28
 */
@Controller
public class GlobalController {
    @RequestMapping("/login")
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
}
