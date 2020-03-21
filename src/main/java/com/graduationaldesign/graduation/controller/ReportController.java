package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.JWT.TokenService;
import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.ReportService;
import com.graduationaldesign.graduation.util.ResponseStatu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @author wuzhuhao
 * @version $Id: ReportController.java, v 0.1 2020-01-21 10:52:27 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/report")
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
            return ResponseStatu.success(reportService.insert(report));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(Integer reportId) {
        try {
            return ResponseStatu.success(reportService.deleteById(reportId));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
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
            return ResponseStatu.success(message);
        } catch (Exception e) {
            return ResponseStatu.failure(e.getMessage());
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
            return ResponseStatu.success(reportService.selectById(reportId));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
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
            return ResponseStatu
                    .success(reportService
                            .listByPage(params, page, pageSize, reportType));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("获取列表失败");
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
            return ResponseStatu.success(reportService.listByPageOfStu(params, page,
                    pageSize
                    , student
                    , reportType));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("获取列表失败");
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
            return ResponseStatu.success(reportService.listByPageOfTea(params, page,
                    pageSize,
                    teacher
                    , reportType));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("获取列表失败");
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteReportList(
            @RequestParam(value = "primaryKey") List<Integer> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            reportService.deleteByPrimaryKeyIn(lstprimaryKey);
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
    public ResponseEntity<Object> updateReport(List<Report> lstReport) {
        try {
            return reportService.updateListByPrimaryKeySelective(lstReport);
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

    @RequestMapping("/export")
    public ResponseEntity<Object> export(String subId, Integer type) {
        try {
            reportService.export(request, response, subId, type);
            return ResponseStatu.success("下载成功");
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file, String subId, Integer type) {
        try {
            reportService.uploadFile(file, subId, type, false);
            return ResponseStatu.success("上传文件成功");
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/uploadTemp", method = RequestMethod.POST)
    public ResponseEntity<Object> uploadTemp(@RequestParam("file") MultipartFile file, String subId, Integer type) {
        try {
            reportService.uploadFile(file, subId, type, true);
            return ResponseStatu.success("上传模板成功");
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }
}