package com.graduationaldesign.graduation.controller;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.ScoreRecord;
import com.graduationaldesign.graduation.service.ScoreRecordService;
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
 * @version $Id: ScoreRecordController.java, v 0.1 2020-03-14 14:37:57 Administrator Exp $$
 */
@RestController
@RequestMapping("/scoreRecord")
public class ScoreRecordController {
    @Autowired
    ScoreRecordService scoreRecordService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(ScoreRecord record) {
        ResponseEntity<Object> result = null;
        if (scoreRecordService.insertSelective(record) <= 0) {
            result = ResponseStatus.failure(
                    MessageFormat.format("添加{0}失败", rootPropeties.getScoreRecord()), this);
        } else {
            result = ResponseStatus.success(
                    MessageFormat.format("添加{0}成功", rootPropeties.getScoreRecord()));
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(ScoreRecord record) {
        ResponseEntity<Object> result = null;
        if (scoreRecordService.updateByPrimaryKeySelective(record) <= 0) {
            result = ResponseStatus.failure(
                    MessageFormat.format("修改{0}失败", rootPropeties.getScoreRecord()), this);
        } else {
            result = ResponseStatus.success(
                    MessageFormat.format("修改{0}成功", rootPropeties.getScoreRecord()));
        }
        return result;

    }

    @RequestMapping(value = "/delete/{primaryKey}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(
            @PathVariable(value = "primaryKey") Integer primaryKey) {
        ResponseEntity<Object> result = null;
        if (scoreRecordService.deleteByPrimaryKey(primaryKey) <= 0) {
            result = ResponseStatus.failure(
                    MessageFormat.format("删除{0}失败", rootPropeties.getScoreRecord()), this);
        } else {
            result = ResponseStatus.success(
                    MessageFormat.format("删除{0}成功", rootPropeties.getScoreRecord()));
        }
        return result;
    }

    @RequestMapping(value = "/getDetail/{primaryKey}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable(value = "primaryKey") Integer primaryKey) {
        ResponseEntity<Object> result = null;
        ScoreRecord record = scoreRecordService.selectByPrimaryKey(primaryKey);
        if (record == null) {
            result = ResponseStatus.failure(
                    MessageFormat.format("该{0}不存在", rootPropeties.getScoreRecord()), this);
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
            return ResponseStatus.success(scoreRecordService.listByPage(params, page, pageSize), this);
        } catch (Exception e) {
            return ResponseStatus.failure(
                    MessageFormat.format("获取{0}列表失败", rootPropeties.getAcademy()), this);
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteScoreRecordList(List<Integer> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            scoreRecordService.deleteByPrimaryKeyIn(lstprimaryKey);
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
    public ResponseEntity<Object> updateScoreRecord(@RequestBody List<ScoreRecord> lstScoreRecord) {
        try {
            return scoreRecordService.updateListByPrimaryKeySelective(lstScoreRecord);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }
}