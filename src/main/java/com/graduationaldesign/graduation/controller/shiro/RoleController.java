package com.graduationaldesign.graduation.controller.shiro;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.controller.Api;
import com.graduationaldesign.graduation.pojo.Role;
import com.graduationaldesign.graduation.service.RoleService;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;


/**
 * @author wuzhuhao
 * @version $Id: RoleController.java, v 0.1 2020-02-20 00:27:05 wuzhuhao Exp $$
 */
@Controller
@RestController
@RequestMapping("/role")
@Api(Pojo = "Role", description = "角色表")
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(Role record) {
        ResponseEntity<Object> result = null;
        if (roleService.insertSelective(record) <= 0) {
            result = ResponseStatus.failure(
                    MessageFormat.format("添加{0}失败", rootPropeties.getRole()), this);
        } else {
            result = ResponseStatus.success(
                    MessageFormat.format("添加{0}成功", rootPropeties.getRole()));
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(Role record) {
        ResponseEntity<Object> result = null;
        if (roleService.updateByPrimaryKeySelective(record) <= 0) {
            result = ResponseStatus.failure(
                    MessageFormat.format("修改{0}失败", rootPropeties.getRole()), this);
        } else {
            result = ResponseStatus.success(
                    MessageFormat.format("修改{0}成功", rootPropeties.getRole()));
        }
        return result;

    }

    @RequestMapping(value = "/delete/{primaryKey}", method = RequestMethod.GET)
    public ResponseEntity<Object> deleteSubject(
            @PathVariable(value = "primaryKey") long primaryKey) {
        ResponseEntity<Object> result = null;
        if (roleService.deleteByPrimaryKey(primaryKey) <= 0) {
            result = ResponseStatus.failure(
                    MessageFormat.format("删除{0}失败", rootPropeties.getRole()), this);
        } else {
            result = ResponseStatus.success(
                    MessageFormat.format("删除{0}成功", rootPropeties.getRole()));
        }
        return result;
    }

    @RequestMapping(value = "/getDetail/{primaryKey}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable(value = "primaryKey") long primaryKey) {
        ResponseEntity<Object> result = null;
        Role record = roleService.selectByPrimaryKey(primaryKey);
        if (record == null) {
            result = ResponseStatus.failure(
                    MessageFormat.format("该{0}不存在", rootPropeties.getRole()), this);
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
                    .success(roleService.listByPage(params, page, pageSize), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public ResponseEntity<Object> deleteRoleList(List<Long> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            roleService.deleteByPrimaryKeyIn(lstprimaryKey);
            result = ResponseStatus.success(
                    MessageFormat.format("批量删除{0}成功", rootPropeties.getAcademy()));
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatus.failure(
                    MessageFormat.format("批量删除{0}失败", rootPropeties.getAcademy()), this);
        }
        return result;
    }

    @RequestMapping(value = "/listUpdate", method = RequestMethod.POST)
    public ResponseEntity<Object> updateRole(List<Role> lstRole) {
        try {
            return roleService.updateListByPrimaryKeySelective(lstRole);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

}