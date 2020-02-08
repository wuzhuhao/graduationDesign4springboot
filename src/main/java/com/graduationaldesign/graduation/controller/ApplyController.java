package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.service.ApplyService;
import com.graduationaldesign.graduation.util.ResponseStatu;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 * @author wuzhuhao
 * @version $Id: ApplyController.java, v 0.1 2020-01-21 10:49:43 wuzhuhao Exp $$
 */
@Controller
public class ApplyController {

    @Autowired
    ApplyService applyService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;

    //    @RequestMapping(value="/temp")
    public ResponseEntity<Object> temp() {
        request.getSession().removeAttribute(rootPropeties.getUserAttribute());
        return ResponseStatu.success("退出登陆成功");
    }
}