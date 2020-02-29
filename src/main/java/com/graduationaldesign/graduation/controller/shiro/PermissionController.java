package com.graduationaldesign.graduation.controller.shiro;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Permission;
import com.graduationaldesign.graduation.service.PermissionService;
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
 * @version $Id: PermissionController.java, v 0.1 2020-02-20 00:33:39 wuzhuhao Exp $$
 */
@Controller
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(Permission record) {
        ResponseEntity<Object> result = null;
        if (permissionService.insertSelective(record) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("添加{0}失败", rootPropeties.getPermission()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("添加{0}成功", rootPropeties.getPermission()));
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(Permission record) {
        ResponseEntity<Object> result = null;
        if (permissionService.updateByPrimaryKeySelective(record) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("修改{0}失败", rootPropeties.getPermission()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("修改{0}成功", rootPropeties.getPermission()));
        }
        return result;

    }

    @RequestMapping(value = "/delete/{primaryKey}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(
            @PathVariable(value = "primaryKey") long primaryKey) {
        ResponseEntity<Object> result = null;
        if (permissionService.deleteByPrimaryKey(primaryKey) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("删除{0}失败", rootPropeties.getPermission()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("删除{0}成功", rootPropeties.getPermission()));
        }
        return result;
    }

    @RequestMapping(value = "/getDetail/{primaryKey}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable(value = "primaryKey") long primaryKey) {
        ResponseEntity<Object> result = null;
        Permission record = permissionService.selectByPrimaryKey(primaryKey);
        if (record == null) {
            result = ResponseStatu.failure(
                    MessageFormat.format("该{0}不存在", rootPropeties.getPermission()));
        } else {
            result = ResponseStatu.success(record);
        }
        return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatu
                    .success(permissionService.listByPage(params, page, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("获取列表失败");
        }
    }
}