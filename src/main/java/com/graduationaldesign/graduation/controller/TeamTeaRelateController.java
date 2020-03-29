package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.TeamTeaRelate;
import com.graduationaldesign.graduation.service.TeamTeaRelateService;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

//
///**
// * @author wuzhuhao
// * @version $Id: teamTeaRelateController.java, v 0.1 2020-03-28 23:28:17 Administrator Exp $$
// */
//@RestController
//@RequestMapping("/teamTeaRelate")
//public class TeamTeaRelateController {
//    @Autowired
//    TeamTeaRelateService teamTeaRelateService;
//    @Autowired
//    HttpServletRequest request;
//    @Autowired
//    RootPropeties rootPropeties;
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ResponseEntity<Object> add(TeamTeaRelate record) {
//        ResponseEntity<Object> result = null;
//        if (teamTeaRelateService.insertSelective(record) <= 0) {
//            result = ResponseStatus.failure(MessageFormat.format("添加{0}失败", rootPropeties.getTeamTeaRelate()), this);
//        } else {
//            result = ResponseStatus.success(MessageFormat.format("添加{0}成功", rootPropeties.getTeamTeaRelate()), this);
//        }
//        return result;
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public ResponseEntity<Object> update(TeamTeaRelate record) {
//        ResponseEntity<Object> result = null;
//        if (teamTeaRelateService.updateByPrimaryKeySelective(record) <= 0) {
//            result = ResponseStatus.failure(MessageFormat.format("修改{0}失败", rootPropeties.getTeamTeaRelate()), this);
//        } else {
//            result = ResponseStatus.success(MessageFormat.format("修改{0}成功", rootPropeties.getTeamTeaRelate()), this);
//        }
//        return result;
//
//    }
//
//    @RequestMapping(value = "/delete/{primaryKey}", method = RequestMethod.DELETE)
//    public ResponseEntity<Object> deleteSubject(
//            @PathVariable(value = "primaryKey") Integer primaryKey) {
//        ResponseEntity<Object> result = null;
//        if (teamTeaRelateService.deleteByPrimaryKey(primaryKey) <= 0) {
//            result = ResponseStatus.failure(MessageFormat.format("删除{0}失败", rootPropeties.getTeamTeaRelate()), this);
//        } else {
//            result = ResponseStatus.success(MessageFormat.format("删除{0}成功", rootPropeties.getTeamTeaRelate()), this);
//        }
//        return result;
//    }
//
//    @RequestMapping(value = "/getDetail/{primaryKey}", method = RequestMethod.GET)
//    public ResponseEntity<Object> getDetail(@PathVariable(value = "primaryKey") Integer primaryKey) {
//        ResponseEntity<Object> result = null;
//        TeamTeaRelate record = teamTeaRelateService.selectByPrimaryKey(primaryKey);
//        if (record == null) {
//            result = ResponseStatus.failure(MessageFormat.format("该{0}不存在", rootPropeties.getTeamTeaRelate()), this);
//        } else {
//            result = ResponseStatus.success(record, this);
//        }
//        return result;
//    }
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "5") int pageSize) {
//        return ResponseStatus.success(teamTeaRelateService.listByPage(params, page, pageSize), this);
//    }
//
//    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
//    public ResponseEntity<Object> deleteTeamTeaRelateList(List<Integer> lstprimaryKey) {
//        ResponseEntity<Object> result = null;
//        try {
//            teamTeaRelateService.deleteByPrimaryKeyIn(lstprimaryKey);
//            result = ResponseStatus.success(MessageFormat.format("批量删除{0}成功", rootPropeties.getAcademy()), this);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result = ResponseStatus.failure(MessageFormat.format("批量删除{0}失败", rootPropeties.getAcademy()), this);
//        }
//        return result;
//    }
//
//    @RequestMapping(value = "/listUpdate", method = RequestMethod.POST)
//    public ResponseEntity<Object> updateTeamTeaRelate(@RequestBody List<TeamTeaRelate> lstteamTeaRelate) {
//        try {
//            return teamTeaRelateService.updateListByPrimaryKeySelective(lstteamTeaRelate);
//        } catch (RuntimeException e) {
//            return ResponseStatus.failure(e.getMessage(), this);
//        }
//    }
//}