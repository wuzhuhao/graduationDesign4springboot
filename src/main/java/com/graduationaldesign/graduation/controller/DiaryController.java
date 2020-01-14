package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.service.DiaryService;
import com.graduationaldesign.graduation.util.Result;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/10 22:36
 */
@Controller
public class DiaryController {
//    @Autowired
//    DiaryService diaryService;
//    @RequestMapping(value="/list" ,produces = "application/json; charset=utf-8")
//    @ResponseBody
//    public ResponseEntity<Object> list(Integer userid,Integer page){
//        return ResponseEntity.status(HttpStatus.SC_OK).body(Result.success(diaryService.listByPage(userid,page)));
//    }
}
