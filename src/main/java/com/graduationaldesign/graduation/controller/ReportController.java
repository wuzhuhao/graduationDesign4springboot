package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.service.ReportService;
import com.graduationaldesign.graduation.util.ResponseStatu;
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

    //    @RequestMapping(value="/temp")
    public ResponseEntity<Object> temp() {
        request.getSession().removeAttribute(rootPropeties.getUserAttribute());
        return ResponseStatu.success("退出登陆成功");
    }

    /**
     * 修改报告
     *
     * @param report
     * @return
     */
    @RequestMapping(value = "/update")
    public ResponseEntity<Object> update(Report report) {
        try {
            return ResponseStatu.success(reportService.updateByPrimaryKeySelective(report));
        } catch (RuntimeException e) {
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
    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params, int page) {
        try {
            return ResponseStatu
                    .success(reportService.listByPage(params, page, rootPropeties.getPageSize()));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

    /**
     * 学生端请求报告列表
     *
     * @return
     */
    @RequestMapping(value = "/listOfStu", method = RequestMethod.GET)
    public ResponseEntity<Object> listOfStu(@RequestParam HashMap<String, Object> params,
            int page, int reportType, String stuId) {
        Student student = (Student) request.getSession()
                .getAttribute(rootPropeties.getUserAttribute());
        student = new Student();
        student.setStuId(stuId);
        return ResponseStatu.success(reportService.listByPageOfStu(params, page,
                rootPropeties.getPageSize()
                , student
                , reportType));
    }

    /**
     * 获取老师的全部选题
     *
     * @return
     */
//    @RequestMapping(value = "/listOfTea", method = RequestMethod.GET)
//    public ResponseEntity<Object> listOfTea(@RequestParam HashMap<String, Object> params,
//            int page) {
//        return ResponseStatu.success(reportService.listByPageOfTea(params, page,
//                rootPropeties.getPageSize(),
//                ((Teacher) request.getSession().getAttribute(rootPropeties.getUserAttribute()))
//        ));
//    }
}