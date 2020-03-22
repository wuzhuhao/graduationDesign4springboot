package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.ReportMapper;
import com.graduationaldesign.graduation.mapper.SubjectMapper;
import com.graduationaldesign.graduation.pojo.*;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.SubjectService;
import com.graduationaldesign.graduation.util.IDUtil;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatu;
import com.graduationaldesign.graduation.util.SqlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课题服务实现类
 *
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:10
 */
@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;
    @Resource
    private ReportMapper reportMapper;
    @Autowired
    private RootPropeties rootPropeties;
    @Autowired
    FileUploadServiceImpl fileUploadService;
    final String FILE_PATH = System.getProperty("user.dir") + "/upload/" + this.getClass().getName().substring(0, this.getClass().getName().indexOf("ServiceImpl")) + "/";

    /*==============私有接口=====================*/

    /*==============公开接口=====================*/
    @Override
    public String deleteByPrimaryKey(String subId) {
        String message = "删除课题成功";
        Subject subject = selectByPrimaryKey(subId);
        File file = new File(subject.getSubFile());
        if (file.exists()) {
            file.delete();
        }
        if (subjectMapper.deleteByPrimaryKey(subId) <= 0) {
            message = "删除课题失败";
        }
        return message;
    }

    @Override
    public ResponseEntity<Object> insert(Subject record) {
        String message = "增加课题成功！";
        try {
            record.setSubId(IDUtil.generateSubID(record.getSubSource()));
        } catch (NullPointerException ne) {
            message = "参数错误，请检查参数！";
        }
        if (subjectMapper.insert(record) <= 0) {
            message = "增加课题失败！";
        } else {
            Report one = new Report(record.getSubId(), 1, 1);
            Report two = new Report(record.getSubId(), 2, 1);
            reportMapper.insertSelective(one);
            reportMapper.insertSelective(two);
        }
        return ResponseStatu.success(message);
    }

    @Override
    public int insertSelective(Subject record) {
        return subjectMapper.insertSelective(record);
    }

    @Override
    public Subject selectByPrimaryKey(String subId) {
        return subjectMapper.selectByPrimaryKey(subId);
    }

    @Override
    public ResponseEntity<Object> updateByPrimaryKeySelective(Subject record) {
        String message = "修改课题成功";
        if (subjectMapper.updateByPrimaryKeySelective(record) <= 0) {
            message = "修改课题失败";
        }
        return ResponseStatu.success(message);
    }

    @Override
    public int updateByPrimaryKey(Subject record) {
        return subjectMapper.updateByPrimaryKey(record);
    }


    /**
     * 选题service层
     *
     * @param subId
     * @return
     */
    @Override
    public String ChoiceSubject(String subId, Student student) {
        Subject subject = subjectMapper.selectByPrimaryKey(subId);
        String message = "选定课题成功";
        if (subject == null || subject.getSubStuState() == null || (!subject.getSubStuState()
                .equals(1))) {
            return "选定课题失败，请刷新页面";
        }
        subject.setSubStuState(2);
        subject.setStuId(student.getStuId());
        if (subjectMapper.updateByPrimaryKey(subject) <= 0) {
            message = "选定课题失败，请刷新页面";
        }
        return message;
    }

    @Override
    public String cancelChoice(String subId, Student student) {
        Subject subject = subjectMapper.selectByPrimaryKey(subId);
        String message = "取消选定课题成功";
        try {
            if (subject.getSubStuState().equals(1)) {
                return "取消选定课题失败，请刷新页面";
            } else if (!subject.getStuId().equals(student.getStuId())) {
                return "取消选定课题失败，请刷新页面";
            }
        } catch (NullPointerException e) {
            return "取消选定课题失败，请刷新页面";
        }
        subject.setSubStuState(1);
        subject.setStuId(null);
        if (subjectMapper.updateByPrimaryKey(subject) <= 0) {
            message = "取消选定课题失败，请刷新页面";
        }
        return message;
    }

    /**
     * 选题列表service层
     *
     * @param params
     * @param page
     * @return
     */
    @Override
    public PageBean<Subject> listByPageOfNotChoice(HashMap<String, Object> params, int page,
                                                   int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Subject> pageBean = new PageBean<>();
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
//        if (uid!=0){
//            criteria.andDidEqualTo(uid);
//            Map<String,Object> param = new HashMap<String, Object>();
//            param.put("uid",uid);
//            pageBean.setParams(param);
//        }
//        diaryExample.setOrderByClause("dTime desc");
        ExampleHelper.addCondition(Subject.class, criteria, params);
        criteria.andSubStuStateEqualTo(1);
        List<Subject> list = subjectMapper.selectByExampleWithBLOBs(subjectExample);
//        for (Subject sub : list) {
//            sub.getTeacher();
//            sub.getStudent();
//        }
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public PageBean<Subject> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Subject> pageBean = new PageBean<>();
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
        ExampleHelper.addCondition(Subject.class, criteria, params);
        List<Subject> list = subjectMapper.selectByExampleWithBLOBs(subjectExample);
        for(Subject sub:list){
            sub.getTeacher().getTeaName();
        }
        pageBean.setBeanList(list);
//        pageBean.setParams(params);
        return pageBean;
    }

    /**
     * 获取已选列表service层
     *
     * @param params
     * @param page
     * @return
     */
    @Override
    public PageBean<Subject> listByPageOfChoice(HashMap<String, Object> params, int page,
                                                int pageSize, Student student)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Subject> pageBean = new PageBean<>();
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
        ExampleHelper.addCondition(Subject.class, criteria, params);
        criteria.andStuIdEqualTo(student.getStuId());
        criteria.andSubStuStateNotEqualTo(1);
        List<Subject> list = subjectMapper.selectByExampleWithBLOBs(subjectExample);
        for (Subject sub : list) {
            sub.getTeacher();
            sub.getStudent();
        }
        pageBean.setBeanList(list);
//        pageBean.setParams();
        return pageBean;
    }

    @Override
    public PageBean<Subject> listByPageOfTea(HashMap<String, Object> params, int page,
                                             int pageSize, Teacher teacher)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Subject> pageBean = new PageBean<>();
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
        ExampleHelper.addCondition(Subject.class, criteria, params);
        criteria.andSubTeaIdEqualTo(teacher.getTeaId());
//        criteria.andSubStuStateNotEqualTo(1);
        List<Subject> list = subjectMapper.selectByExampleWithBLOBs(subjectExample);
        for (Subject sub : list) {
            sub.getTeacher();
            sub.getStudent();
        }
        pageBean.setBeanList(list);
        return pageBean;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<String> lstPrimaryKey) throws Exception {
        SubjectExample example = new SubjectExample();
        SubjectExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdIn(lstPrimaryKey);
        subjectMapper.deleteByExample(example);
    }

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Subject> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getSubject());
        try {
            subjectMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getSubject());
        }
        return ResponseStatu.success(message);
    }

    /**
     * 查询teacher已被选课题列表
     *
     * @param params
     * @param page
     * @param pageSize
     * @param teacher
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @Override
    public PageBean<Map<String, Object>> listChoosedByPageOfTea(HashMap<String, Object> params, int page,
                                                                int pageSize, Teacher teacher)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Map<String, Object>> pageBean = new PageBean<>();
        SubjectExample subjectExample = new SubjectExample();
        Map<String, String> ma = new HashMap<>();
        ma.put("t_subject.sub_name", "subName");
        ma.put("t_subject.sub_id ", "subId");
        ma.put("t_teacher.tea_name", "teaName");
        String s = SqlUtil.spliceResultStringByMap(ma);
        subjectExample.setResultString(" t_subject.sub_name subName,t_subject.sub_id subId,t_teacher.tea_name teaName,t_teacher.tea_id teaId,t_student.stu_name stuName,t_student.stu_id stuId,t_student.stu_major stuMajor,t_task.id taskId,t_task.task_state taskState,t_report.id reportId,t_report.report_type reportType,t_report.report_state reportState,t_scorerecord.reply_score_ replyScore ");
        subjectExample.setJoin(" left join t_student on t_student.stu_id = t_subject.stu_id left join t_teacher on t_teacher.tea_id = t_subject.sub_tea_id left join t_task on t_task.task_sub_id = t_subject.sub_id left join t_report on t_report.report_sub_id = t_subject.sub_id left join t_scorerecord on t_scorerecord.score_sub_id = t_subject.sub_id");
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
        ExampleHelper.addCondition(Subject.class, criteria, params);
        criteria.andSubTeaIdEqualTo(teacher.getTeaId());
        criteria.andSubStuStateNotEqualTo(1);
        List<Map<String, Object>> list = subjectMapper.selectByExampleWithMap(subjectExample);
        list.stream().forEach(e -> e.put("replyState", e.get("replyScore") == null || e.get("replyScore").equals("-1") ? "未开始" : "已完成"));
        pageBean.setBeanList(list);
        return pageBean;
    }

    @Override
    public void uploadSubjectFile(MultipartFile file, String subId) {
        Subject subject = new Subject(subId);
        subject.setSubFile(fileUploadService.singleFile(file, FILE_PATH));
        subjectMapper.updateByPrimaryKeySelective(subject);
    }
}
