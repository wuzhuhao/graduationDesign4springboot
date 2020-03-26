package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.service.AdminService;
import com.graduationaldesign.graduation.util.ResponseStatu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @author wuzhuhao
 * @version $Id: AdminController.java, v 0.1 2020-01-21 10:49:08 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;

    //    @RequestMapping(value="/temp")
    public ResponseEntity<Object> temp() {
        return ResponseStatu.success("退出登陆成功");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(Admin admin) {
        ResponseEntity<Object> result = null;
        if (adminService.insertSelective(admin) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("添加{0}失败", rootPropeties.getAdmin()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("添加{0}成功", rootPropeties.getAdmin()));
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(Admin admin) {
        ResponseEntity<Object> result = null;
        if (adminService.updateByPrimaryKeySelective(admin) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("修改{0}失败", rootPropeties.getAdmin()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("修改{0}成功", rootPropeties.getAdmin()));
        }
        return result;

    }

    @RequestMapping(value = "/delete/{primaryKey}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(
            @PathVariable(value = "primaryKey") String primaryKey) {
        ResponseEntity<Object> result = null;
        if (adminService.deleteByPrimaryKey(primaryKey) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("删除{0}失败", rootPropeties.getAdmin()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("删除{0}成功", rootPropeties.getAdmin()));
        }
        return result;
    }

    @RequestMapping(value = "/getDetail/{primaryKey}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable(value = "primaryKey") String primaryKey) {
        ResponseEntity<Object> result = null;
        Admin record = adminService.selectByPrimaryKey(primaryKey);
        if (record == null) {
            result = ResponseStatu.failure(
                    MessageFormat.format("该{0}不存在", rootPropeties.getAdmin()));
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
                    .success(adminService.listByPage(params, page, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu
                    .failure("获取列表失败");
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAdminList(
            @RequestParam(value = "primaryKey") List<String> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            adminService.deleteByPrimaryKeyIn(lstprimaryKey);
            result = ResponseStatu.success(
                    MessageFormat.format("批量删除{0}成功", rootPropeties.getAcademy()));
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatu.failure(
                    MessageFormat.format("批量删除{0}失败", rootPropeties.getAcademy()));
        }
        return result;
    }

    @RequestMapping(value = "/listUpdate", method = RequestMethod.POST)
    public ResponseEntity<Object> updateAdmin(@RequestBody List<Admin> lstAdmin) {
        try {
            return adminService.updateListByPrimaryKeySelective(lstAdmin);
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

}