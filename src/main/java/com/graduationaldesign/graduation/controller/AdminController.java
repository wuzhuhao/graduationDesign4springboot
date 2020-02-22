package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.service.AdminService;
import com.graduationaldesign.graduation.util.ResponseStatu;
import java.text.MessageFormat;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        request.getSession().removeAttribute(rootPropeties.getUserAttribute());
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

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
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
    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params, int page) {
        return ResponseStatu
                .success(adminService.listByPage(params, page, rootPropeties.getPageSize()));
    }

}