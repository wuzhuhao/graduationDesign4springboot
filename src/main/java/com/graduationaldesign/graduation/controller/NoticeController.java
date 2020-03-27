package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Notice;
import com.graduationaldesign.graduation.service.NoticeService;
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
 * @version $Id: NoticeController.java, v 0.1 2020-02-20 00:23:36 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(Notice record) {
        ResponseEntity<Object> result = null;
        if (noticeService.insertSelective(record) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("添加{0}失败", rootPropeties.getNotice()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("添加{0}成功", rootPropeties.getNotice()));
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(Notice record) {
        ResponseEntity<Object> result = null;
        if (noticeService.updateByPrimaryKeySelective(record) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("修改{0}失败", rootPropeties.getNotice()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("修改{0}成功", rootPropeties.getNotice()));
        }
        return result;

    }

    @RequestMapping(value = "/delete/{primaryKey}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(
            @PathVariable(value = "primaryKey") int primaryKey) {
        ResponseEntity<Object> result = null;
        if (noticeService.deleteByPrimaryKey(primaryKey) <= 0) {
            result = ResponseStatu.failure(
                    MessageFormat.format("删除{0}失败", rootPropeties.getNotice()));
        } else {
            result = ResponseStatu.success(
                    MessageFormat.format("删除{0}成功", rootPropeties.getNotice()));
        }
        return result;
    }

    @RequestMapping(value = "/getDetail/{primaryKey}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable(value = "primaryKey") int primaryKey) {
        ResponseEntity<Object> result = null;
        Notice record = noticeService.selectByPrimaryKey(primaryKey);
        if (record == null) {
            result = ResponseStatu.failure(
                    MessageFormat.format("该{0}不存在", rootPropeties.getNotice()));
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
                    .success(noticeService.listByPage(params, page, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("获取列表失败");
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteNoticeList(
            @RequestParam(value = "primaryKey") List<Integer> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            noticeService.deleteByPrimaryKeyIn(lstprimaryKey);
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
    public ResponseEntity<Object> updateNotice(@RequestBody List<Notice> lstNotice) {
        try {
            return noticeService.updateListByPrimaryKeySelective(lstNotice);
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

}