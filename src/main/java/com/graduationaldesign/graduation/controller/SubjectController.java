package com.graduationaldesign.graduation.controller;


import com.graduationaldesign.graduation.JWT.TokenService;
import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Subject;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.SubjectService;
import com.graduationaldesign.graduation.util.ResponseStatu;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
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
 * @version $Id: SubjectController.java, v 0.1 2020-01-21 10:53:08 wuzhuhao Exp $$
 */
@RestController
@RequestMapping("/sub")
public class SubjectController {

    @Autowired
    SubjectService subjectService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    TokenService tokenService;

    @RequestMapping(value = "/temp")
    public ResponseEntity<Object> temp() {
        return ResponseStatu.success("退出登陆成功");
    }

    /**
     * 增加课题
     *
     * @param subject
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addSubject(Subject subject) {
        try {
            return subjectService.insert(subject);
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }
    }

    /**
     * 修改课题
     *
     * @param subject
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSubject(Subject subject) {
        try {
            return subjectService.updateByPrimaryKeySelective(subject);
        } catch (RuntimeException e) {
            return ResponseStatu.failure(e.getMessage());
        }

    }

    /**
     * 删除课题
     *
     * @param sudId
     * @return
     */
    @RequestMapping(value = "/delete/{sudId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubject(@PathVariable(value = "sudId") String sudId) {
        try {
            return ResponseStatu.success(subjectService.deleteByPrimaryKey(sudId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("请求失败");
        }
    }

    /**
     * 查看课题详情
     *
     * @param sudId
     * @return
     */
    @RequestMapping(value = "/getSubject", method = RequestMethod.GET)
    public ResponseEntity<Object> getSubject(String sudId) {
        try {
            return ResponseStatu.success(subjectService.selectByPrimaryKey(sudId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("请求失败");
        }
    }

    /**
     * 学生请求选题列表
     *
     * @return
     */
    @RequestMapping(value = "/listOfNotChoice", method = RequestMethod.GET)
    public ResponseEntity<Object> getSubjectOfNotChoice(
            @RequestParam HashMap<String, Object> params,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatu.success(
                    subjectService.listByPageOfNotChoice(params, page, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("获取列表失败");
        }
    }

    /**
     * 学生端请求已选题列表
     *
     * @return
     */
    @RequestMapping(value = "/listOfChoice", method = RequestMethod.GET)
    public ResponseEntity<Object> getSubjectOfChoice(@RequestParam HashMap<String, Object> params,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatu.success(subjectService.listByPageOfChoice(params, page,
                    pageSize,
                    ((Student) tokenService.getUserByToken(request))));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("获取列表失败");
        }
    }

    /**
     * 获取老师的全部选题
     *
     * @return
     */
    @RequestMapping(value = "/listOfTea", method = RequestMethod.GET)
    public ResponseEntity<Object> getSubjectOfTea(@RequestParam HashMap<String, Object> params,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatu.success(subjectService.listByPageOfTea(params, page,
                    pageSize,
                    ((Teacher) tokenService.getUserByToken(request))));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("获取列表失败");
        }
    }

    /**
     * 管理员获取选题
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam HashMap<String, Object> params,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        try {
            return ResponseStatu
                    .success(subjectService.listByPage(params, page, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatu.failure("获取列表失败");
        }
    }

    /**
     * 学生选题
     *
     * @param subId
     * @return
     */
    @RequestMapping(value = "/choice", method = RequestMethod.POST)
    public ResponseEntity<Object> choiceSubject(String subId) {
        try {
            return ResponseStatu.success(subjectService.ChoiceSubject(subId,
                    (Student) tokenService.getUserByToken(request)));
        } catch (ClassCastException e) {
            return ResponseStatu.failure("用户异常，请重新登陆");
        }
    }

    /**
     * 学生取消选题
     *
     * @param subId
     * @return
     */
    @RequestMapping(value = "/cancelChoice", method = RequestMethod.POST)
    public ResponseEntity<Object> cancelChoice(String subId) {
        try {
            return ResponseStatu.success(subjectService.cancelChoice(subId,
                    (Student) tokenService.getUserByToken(request)));
        } catch (ClassCastException e) {
            return ResponseStatu.failure("用户异常，请重新登陆");
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubjectList(
            @RequestParam(value = "primaryKey") List<String> lstprimaryKey) {
        ResponseEntity<Object> result = null;
        try {
            subjectService.deleteByPrimaryKeyIn(lstprimaryKey);
            result = ResponseStatu.success(
                    MessageFormat.format("批量删除{0}成功", rootPropeties.getAcademy()));
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatu.failure(
                    MessageFormat.format("批量删除{0}失败", rootPropeties.getAcademy()));
        }
        return result;
    }

}