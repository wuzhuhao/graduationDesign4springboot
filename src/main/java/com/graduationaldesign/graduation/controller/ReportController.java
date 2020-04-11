package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.JWT.TokenService;
import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.ReportService;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @author wuzhuhao
 * @version $Id: ReportController.java, v 0.1 2020-01-21 10:52:27 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/report")
@Api(Pojo = "Report", description = "报告表")
public class ReportController {

    @Autowired
    ReportService reportService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    TokenService tokenService;
    @Autowired
    HttpServletResponse response;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(Report report) {
        try {
            return ResponseStatus.success(reportService.insert(report), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(Integer reportId) {
        try {
            return ResponseStatus.success(reportService.deleteById(reportId), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * 管理员修改报告
     *
     * @param report
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(Report report) {
        try {
            String message = "";
            Object user = tokenService.getUserByToken(request);
            if (user instanceof Student) {
                message = reportService.updateByPrimaryKeySelectiveWithStudent(report);
            } else {
                message = reportService.updateByPrimaryKeySelective(report);
            }
            return ResponseStatus.success(message, this);
        } catch (Exception e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * 获取开题报告或者定稿报告的详情
     *
     * @param reportId 报告id
     * @return
     */
    @RequestMapping(value = "/getDetail/{reportId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDetail(@PathVariable int reportId) {
        try {
            return ResponseStatus.success(reportService.selectById(reportId), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * 管理员获取报告
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params,
                                       @RequestParam(required = false, defaultValue = "1") int page,
                                       int reportType,
                                       @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatus
                    .success(reportService
                            .listByPage(params, page, pageSize, reportType), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    /**
     * 学生端请求报告列表
     *
     * @return
     */
    @RequestMapping(value = "/listOfStu", method = RequestMethod.GET)
    public ResponseEntity<Object> listOfStu(@RequestParam HashMap<String, Object> params,
                                            @RequestParam(required = false, defaultValue = "1") int page, int reportType,
                                            String stuId,
                                            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        Student student = (Student) tokenService.getUserByToken(request);
        student = new Student();
        student.setStuId(stuId);
        try {
            return ResponseStatus.success(reportService.listByPageOfStu(params, page,
                    pageSize
                    , student
                    , reportType), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    /**
     * 获取老师的全部报告
     *
     * @return
     */
    @RequestMapping(value = "/listOfTea", method = RequestMethod.GET)
    public ResponseEntity<Object> listOfTea(@RequestParam HashMap<String, Object> params,
                                            @RequestParam(required = false, defaultValue = "1") int page, int reportType,
                                            String teaId,
                                            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        Teacher teacher = (Teacher) tokenService.getUserByToken(request);
        teacher = new Teacher();
        teacher.setTeaId(teaId);
        try {
            return ResponseStatus.success(reportService.listByPageOfTea(params, page,
                    pageSize,
                    teacher
                    , reportType), this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("获取列表失败", this);
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteReportList(
            @RequestParam(value = "primaryKey") List<Integer> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            reportService.deleteByPrimaryKeyIn(lstprimaryKey);
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
    public ResponseEntity<Object> updateReport(@RequestBody List<Report> lstReport) {
        try {
            return reportService.updateListByPrimaryKeySelective(lstReport);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @RequestMapping("/export")
    public void export(String subId, Integer type) {
        try {
            //todo
            reportService.export(request, response, subId, type);
//            return ResponseStatus.success("下载成功", this);
        } catch (RuntimeException e) {
//            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @RequestMapping("/downloadFile")
    public ResponseEntity<Object> downloadFile(String subId, Integer reportType, Integer fileType) {
        try {
            reportService.downloadFile(request, response, subId, reportType, fileType);
            return ResponseStatus.success("下载成功", this);
        } catch (RuntimeException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * 学生上传报告附件
     *
     * @param file
     * @param subId
     * @param type
     * @return
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file, String subId, Integer type) {
        try {
            reportService.uploadFile(file, subId, type, false);
            return ResponseStatus.success("上传文件成功", this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    /**
     * 教师上传模板
     *
     * @param file
     * @param subId
     * @param type
     * @return
     */
    @RequestMapping(value = "/uploadTemp", method = RequestMethod.POST)
    public ResponseEntity<Object> uploadTemp(@RequestParam("file") MultipartFile file, String subId, Integer type) {
        try {
            reportService.uploadFile(file, subId, type, true);
            return ResponseStatus.success("上传模板成功", this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }
}