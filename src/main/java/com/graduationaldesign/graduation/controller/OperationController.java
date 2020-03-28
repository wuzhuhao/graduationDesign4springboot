package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Operation;
import com.graduationaldesign.graduation.service.OperationService;
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
 * @version $Id: OperationController.java, v 0.1 2020-02-20 00:23:49 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    OperationService operationService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(Operation record) {
        ResponseEntity<Object> result = null;
        if (operationService.insertSelective(record) <= 0) {
            result = ResponseStatus.failure(
                    MessageFormat.format("添加{0}失败", rootPropeties.getOperation()), this);
        } else {
            result = ResponseStatus.success(
                    MessageFormat.format("添加{0}成功", rootPropeties.getOperation()));
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(Operation record) {
        ResponseEntity<Object> result = null;
        if (operationService.updateByPrimaryKeySelective(record) <= 0) {
            result = ResponseStatus.failure(
                    MessageFormat.format("修改{0}失败", rootPropeties.getOperation()), this);
        } else {
            result = ResponseStatus.success(
                    MessageFormat.format("修改{0}成功", rootPropeties.getOperation()));
        }
        return result;

    }

    @RequestMapping(value = "/delete/{primaryKey}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(
            @PathVariable(value = "primaryKey") int primaryKey) {
        ResponseEntity<Object> result = null;
        if (operationService.deleteByPrimaryKey(primaryKey) <= 0) {
            result = ResponseStatus.failure(
                    MessageFormat.format("删除{0}失败", rootPropeties.getOperation()), this);
        } else {
            result = ResponseStatus.success(
                    MessageFormat.format("删除{0}成功", rootPropeties.getOperation()));
        }
        return result;
    }

    @RequestMapping(value = "/getDetail/{primaryKey}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable(value = "primaryKey") int primaryKey) {
        ResponseEntity<Object> result = null;
        Operation record = operationService.selectByPrimaryKey(primaryKey);
        if (record == null) {
            result = ResponseStatus.failure(MessageFormat.format("该{0}不存在", rootPropeties.getOperation()), this);
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
            return ResponseStatus
                    .success(operationService.listByPage(params, page, pageSize), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteOperationList(
            @RequestParam(value = "primaryKey") List<Integer> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            operationService.deleteByPrimaryKeyIn(lstprimaryKey);
            result = ResponseStatus.success(
                    MessageFormat.format("批量删除{0}成功", rootPropeties.getAcademy()));
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatus.failure(MessageFormat.format("批量删除{0}失败", rootPropeties.getAcademy()), this);
        }
        return result;
    }

    @RequestMapping(value = "/listUpdate", method = RequestMethod.POST)
    public ResponseEntity<Object> updateOperation(@RequestBody List<Operation> lstOperation) {
        try {
            return operationService.updateListByPrimaryKeySelective(lstOperation);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

}