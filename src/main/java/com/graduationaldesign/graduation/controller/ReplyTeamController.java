package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.service.impl.ReplyTeamServiceImpl;
import com.graduationaldesign.graduation.util.ResponseStatu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wuzhuhao
 * @version $Id: ReplyTeamController.java, v 0.1 2020-01-21 10:52:13 wuzhuhao Exp $$
 */
@Controller
public class ReplyTeamController{
    @Autowired
    ReplyTeamServiceImpl ReplyTeamMapper;
    @Autowired
    HttpServletRequest request;
    
//    @RequestMapping(value="/temp")
    public ResponseEntity<Object> temp(){
        request.getSession().removeAttribute("LOGIN_USER");
        return ResponseStatu.success("退出登陆成功");
    }
}