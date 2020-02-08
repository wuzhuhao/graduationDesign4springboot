package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.service.ReportService;
import com.graduationaldesign.graduation.util.ResponseStatu;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "/update")
    public ResponseEntity<Object> update(Report report) {
        try {
            return ResponseStatu.success(reportService.updateByPrimaryKeySelective(report));
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

//    @RequestMapping(value = "/getDe")
//    public ResponseEntity<Object> update(Report report) {
//        try {
//            return ResponseStatu.success(reportService.updateByPrimaryKeySelective(report));
//        } catch (RuntimeException e) {
//            return ResponseStatu.failure(e.getMessage());
//        }
//    }
}