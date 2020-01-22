package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.pojo.Subject;
import com.graduationaldesign.graduation.service.impl.SubjectServiceImpl;
import com.graduationaldesign.graduation.util.IDUtil;
import com.graduationaldesign.graduation.util.ResponseStatu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wuzhuhao
 * @version $Id: SubjectController.java, v 0.1 2020-01-21 10:53:08 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/sub")
public class SubjectController{
    @Autowired
    SubjectServiceImpl subjectService;
    @Autowired
    HttpServletRequest request;
    
    @RequestMapping(value="/temp")
    public ResponseEntity<Object> temp(){
        request.getSession().removeAttribute("LOGIN_USER");
        return ResponseStatu.success("退出登陆成功");
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public ResponseEntity<Object> addSubject(Subject subject){
        return ResponseStatu.success(subjectService.insert(subject));
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSubject(Subject subject){
        return ResponseStatu.success(subjectService.updateByPrimaryKeySelective(subject));
    }

    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(String sudId){
        return ResponseStatu.success(subjectService.deleteByPrimaryKey(sudId));
    }

    @RequestMapping(value="/getSubject",method = RequestMethod.GET)
    public ResponseEntity<Object> temp(String sudId){
        return ResponseStatu.success(subjectService.selectByPrimaryKey(sudId));
    }
}