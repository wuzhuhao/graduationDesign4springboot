package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Apply;
import com.graduationaldesign.graduation.service.ApplyService;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;


/**
 * @author wuzhuhao
 * @version $Id: ApplyController.java, v 0.1 2020-02-20 00:18:35 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    ApplyService applyService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(Apply record) {
        ResponseEntity<Object> result = null;
        if (applyService.insertSelective(record) <= 0) {
            result = ResponseStatus.failure(MessageFormat.format("添加{0}失败", rootPropeties.getApply()), this);
        } else {
            result = ResponseStatus.success(MessageFormat.format("添加{0}成功", rootPropeties.getApply()));
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(Apply record) {
        ResponseEntity<Object> result = null;
        if (applyService.updateByPrimaryKeySelective(record) <= 0) {
            result = ResponseStatus.failure(MessageFormat.format("修改{0}失败", rootPropeties.getApply()), this);
        } else {
            result = ResponseStatus.success(MessageFormat.format("修改{0}成功", rootPropeties.getApply()));
        }
        return result;

    }

    @RequestMapping(value = "/delete/{primaryKey}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(
            @PathVariable(value = "primaryKey") int primaryKey) {
        ResponseEntity<Object> result = null;
        if (applyService.deleteByPrimaryKey(primaryKey) <= 0) {
            result = ResponseStatus.failure(MessageFormat.format("删除{0}失败", rootPropeties.getApply()), this);
        } else {
            result = ResponseStatus.success(MessageFormat.format("删除{0}成功", rootPropeties.getApply()));
        }
        return result;
    }

    @RequestMapping(value = "/getDetail/{primaryKey}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable(value = "primaryKey") int primaryKey) {
        ResponseEntity<Object> result = null;
        Apply record = applyService.selectByPrimaryKey(primaryKey);
        if (record == null) {
            result = ResponseStatus.failure(MessageFormat.format("该{0}不存在", rootPropeties.getApply()), this);
        } else {
            result = ResponseStatus.success(record, this);
        }
        return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params,
                                       @RequestParam(required = false, defaultValue = "1") int page,
                                       @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatus.success(applyService.listByPage(params, page, pageSize), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("列表获取失败", this);
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteApplyList(
            @RequestParam(value = "primaryKey") List<Integer> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            applyService.deleteByPrimaryKeyIn(lstprimaryKey);
            result = ResponseStatus.success(MessageFormat.format("批量删除{0}成功", rootPropeties.getAcademy()));
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatus.failure(MessageFormat.format("批量删除{0}失败", rootPropeties.getAcademy()), this);
        }
        return result;
    }

    @RequestMapping(value = "/listUpdate", method = RequestMethod.POST)
    public ResponseEntity<Object> updateApply(List<Apply> lstApply) {
        try {
            return applyService.updateListByPrimaryKeySelective(lstApply);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

}