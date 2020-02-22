package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Operation;
import com.graduationaldesign.graduation.service.OperationService;
import com.graduationaldesign.graduation.util.ResponseStatu;
import java.text.MessageFormat;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wuzhuhao
 * @version $Id: OperationController.java, v 0.1 2020-02-20 00:23:49 wuzhuhao Exp $$
 */
@Controller
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
            result = ResponseStatu.failure(
                    MessageFormat.format("添加{0}失败", rootPropeties.getOperation()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("添加{0}成功", rootPropeties.getOperation()));
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(Operation record) {
        ResponseEntity<Object> result = null;
        if (operationService.updateByPrimaryKeySelective(record) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("修改{0}失败", rootPropeties.getOperation()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("修改{0}成功", rootPropeties.getOperation()));
        }
        return result;

    }

    @RequestMapping(value = "/delete/{primaryKey}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(
            @PathVariable(value = "primaryKey") int primaryKey) {
        ResponseEntity<Object> result = null;
        if (operationService.deleteByPrimaryKey(primaryKey) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("删除{0}失败", rootPropeties.getOperation()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("删除{0}成功", rootPropeties.getOperation()));
        }
        return result;
    }

    @RequestMapping(value = "/getDetail/{primaryKey}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable(value = "primaryKey") int primaryKey) {
        ResponseEntity<Object> result = null;
        Operation record = operationService.selectByPrimaryKey(primaryKey);
        if (record == null) {
            result = ResponseStatu.failure(
                    MessageFormat.format("该{0}不存在", rootPropeties.getOperation()));
        } else {
            result = ResponseStatu.success(record);
        }
        return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params, int page) {
        return ResponseStatu
                .success(operationService.listByPage(params, page, rootPropeties.getPageSize()));
    }
}