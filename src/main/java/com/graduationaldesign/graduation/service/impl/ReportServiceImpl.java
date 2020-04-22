package com.graduationaldesign.graduation.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.ReportMapper;
import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.pojo.ReportExample;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.FileDownService;
import com.graduationaldesign.graduation.service.ReportService;
import com.graduationaldesign.graduation.util.FileUtil;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportMapper reportMapper;
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    FileUploadServiceImpl fileUploadService;
    @Autowired
    FileDownService fileDownService;
    //    final String FILE_PATH = System.getProperty("user.dir") + "/upload/" + this.getClass().getName().substring(0, this.getClass().getName().indexOf("ServiceImpl")) + "/";
    final String FILE_PATH = "/usr/local/graduation/upload/" + this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().indexOf("ServiceImpl")) + "/";

    @Override
    public int deleteByPrimaryKey(String subId, Integer reportType) {
        return reportMapper.deleteByPrimaryKey(subId, reportType);
    }

    @Override
    public String deleteById(Integer reportId) {
        if (reportId == null) {
            throw new RuntimeException("删除报告失败，id不能为空");
        }
        ReportExample example = new ReportExample();
        example.createCriteria().andIdEqualTo(reportId);
        if (reportMapper.deleteByExample(example) <= 0) {
            throw new RuntimeException("删除报告失败");
        }
        return "删除报告成功";
    }

    @Override
    public String insert(Report record) {
        record.setReportSubtime(new Date());
        record.setReportVersion(1F);
        if (reportMapper.insert(record) <= 0) {
            throw new RuntimeException("增加报告失败");
        }
        return "增加报告成功";
    }

    @Override
    public int insertSelective(Report record) {
        return reportMapper.insertSelective(record);
    }

    @Override
    public Report selectByPrimaryKey(String subId, Integer reportType) {
        return reportMapper.selectByPrimaryKey(subId, reportType);
    }

    @Override
    public String updateByPrimaryKeySelective(Report record) throws RuntimeException {
        String message = "修改成功";
        ReportExample example = new ReportExample();
        example.createCriteria().andIdEqualTo(record.getId());
        if (reportMapper.updateByExampleSelective(record, example) <= 0) {
            throw new RuntimeException("修改失败");
        }
        return message;
    }

    @Override
    public String updateByPrimaryKeySelectiveWithStudent(Report record) throws Exception {
        record.setReportVersion(record.getReportVersion() + 1);
        record.setReportSubtime(new Date());
        record.setReportState(updateState(selectById(record.getId())));
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Report record) {
        return reportMapper.updateByPrimaryKey(record);
    }

    @Override
    public Report selectById(int reportId) {
        ReportExample reportExample = new ReportExample();
        ReportExample.Criteria criteria = reportExample.createCriteria();
        criteria.andIdEqualTo(reportId);
        List<Report> list = reportMapper.selectByExampleWithBLOBs(reportExample);
        if (list.size() <= 0) {
            throw new RuntimeException("该报告不存在");
        }
        return list.get(0);
    }

    @Override
    public PageBean<Report> listByPage(HashMap<String, Object> params, int page, Integer pageSize,
                                       int reportType)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<Report> pageBean = new PageBean<>();
        ReportExample reportExample = new ReportExample();
        StringBuilder orderby = new StringBuilder();
        if (params.get("orderId") != null) {
            if (params.get("orderId").equals("2")) {
                orderby.append("id DESC");
            } else {
                orderby.append("id ASC");
            }
        }
        if (params.get("orderTime") != null) {
            if (orderby.length() != 0) {
                orderby.append(",");
            }
            if (params.get("orderTime").equals("2")) {
                orderby.append("report_subtime DESC");
            } else {
                orderby.append("report_subtime ASC");
            }
        }
        if (orderby.length() != 0) {
            reportExample.setOrderByClause(orderby.toString());
        }
        ReportExample.Criteria criteria = reportExample.createCriteria();
        ExampleHelper.searchJoin(Report.class, reportExample, criteria, params);
        if (reportType == 1 || reportType == 2) {
            criteria.andReportTypeEqualTo(reportType);
        }
        ExampleHelper.addCondition(Report.class, criteria, params);
        List<Report> list = reportMapper.selectByExampleWithBLOBs(reportExample);
        for (Report report : list) {
            report.getSubject();
            report.getSubject().getStudent();
            report.getSubject().getTeacher();
        }
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }


    /**
     * 获取学生的报告列表
     *
     * @param params
     * @param page
     * @param pageSize
     * @param student
     * @param reportType
     * @return
     */
    @Override
    public PageBean<Report> listByPageOfStu(HashMap<String, Object> params, int page,
                                            Integer pageSize,
                                            Student student, int reportType)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Report> pageBean = new PageBean<>();
        ReportExample example = new ReportExample();
        example.setJoin("left join t_subject on t_report.report_sub_id = t_subject.sub_id");
        StringBuilder orderby = new StringBuilder();
        if (params.get("orderId") != null) {
            if (params.get("orderId").equals("2")) {
                orderby.append("id DESC");
            } else {
                orderby.append("id ASC");
            }
        }
        if (params.get("orderTime") != null) {
            if (orderby.length() != 0) {
                orderby.append(",");
            }
            if (params.get("orderTime").equals("2")) {
                orderby.append("report_subtime DESC");
            } else {
                orderby.append("report_subtime ASC");
            }
        }
        ReportExample.Criteria criteria = example.createCriteria();
        criteria.andJoinStuIdEqualTo(student.getStuId());
        ExampleHelper.addCondition(Report.class, criteria, params);
        if (reportType == 1 || reportType == 2) {
            criteria.andReportTypeEqualTo(reportType);
        }
        List<Report> list = reportMapper.selectByExampleWithBLOBs(example);
        pageBean.setBeanList(list);
        for (Report report : list) {
            report.getSubject();
            report.getSubject().getStudent();
            report.getSubject().getTeacher();
        }
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public PageBean<Report> listByPageOfTea(HashMap<String, Object> params, int page,
                                            Integer pageSize, Teacher teacher, int reportType)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Report> pageBean = new PageBean<>();
        ReportExample example = new ReportExample();
        example.setJoin("left join t_subject on t_report.report_sub_id = t_subject.sub_id");
        StringBuilder orderby = new StringBuilder();
        if (params.get("orderId") != null) {
            if (params.get("orderId").equals("2")) {
                orderby.append("id DESC");
            } else {
                orderby.append("id ASC");
            }
        }
        if (params.get("orderTime") != null) {
            if (orderby.length() != 0) {
                orderby.append(",");
            }
            if (params.get("orderTime").equals("2")) {
                orderby.append("report_subtime DESC");
            } else {
                orderby.append("report_subtime ASC");
            }
        }
        ReportExample.Criteria criteria = example.createCriteria();
        criteria.andJoinTeaIdEqualTo(teacher.getTeaId());
        criteria.andJoinStuIdNotEqualTo("");
        ExampleHelper.addCondition(Report.class, criteria, params);
        if (reportType == 1 || reportType == 2) {
            criteria.andReportTypeEqualTo(reportType);
        }
        List<Report> list = reportMapper.selectByExampleWithBLOBs(example);
        for (Report report : list) {
            report.getSubject();
            report.getSubject().getStudent();
            report.getSubject().getTeacher();
        }
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        ReportExample example = new ReportExample();
        ReportExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        reportMapper.deleteByExample(example);
    }

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Report> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getReport());
        try {
            reportMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getReport());
        }
        return ResponseStatus.success(message);
    }

    @Override
    public void uploadFile(MultipartFile file, String subId, Integer type, boolean isTemp) {
        Report report = new Report(subId, type);
        if (!isTemp) {
            report.setReportFile(fileUploadService.singleFile(file, FILE_PATH));
        } else {
            report.setReportTemp(fileUploadService.singleFile(file, FILE_PATH));
        }
        try {
            reportMapper.updateByPrimaryKeySelective(report);
        } catch (Exception e) {
            e.printStackTrace();
            fileUploadService.deleteFile(FILE_PATH, report.getReportFile());
            throw new RuntimeException("上传失败");
        }
    }

    @Override
    public void export(HttpServletRequest request, HttpServletResponse response, String subId, Integer type) {
        Map<String, Object> params = new HashMap<>();
        Report report = reportMapper.selectByPrimaryKey(subId, type);
        report.getSubject();
        report.getSubject().getStudent();
        report.getSubject().getTeacher();
        params.put("reportContent", report.getReportContent());
        params.put("subject", report.getSubject());
//        params = BeanUtil.beanToMap(report);
//        String fileString = "word/firstReport.docx";
        String fileString = "/usr/local/graduation/word/firstReport.docx";
        if (type != null && type.equals(2)) {
            fileString = "word/finalReport.docx";
        }
        //这里是我说的一行代码
        FileUtil.exportWord(fileString, "/test", "开题报告.docx", params, request, response);
    }

    @Override
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String subId, Integer reportType, Integer fileType) throws UnsupportedEncodingException {
        Report report = reportMapper.selectByPrimaryKey(subId, reportType);
        if (report == null || report.getId() == 0) {
            throw new RuntimeException("数据不存在，请检查数据");
        }
        String typeName = "附件";
        if (fileType.equals(2)) {
            typeName = "模板";
        }
        String viewName = report.getSubject().getSubName() + "开题报告" + typeName;
        if (report.getReportFile() == null || report.getReportFile().equals("")) {
            throw new RuntimeException("未有附件");
        }
        String file = FILE_PATH + report.getReportFile();
        if (fileType.equals(2)) {
            file = FILE_PATH + report.getReportTemp();
            viewName = report.getSubject().getSubName() + "终稿" + typeName;
        }
        fileDownService.download(response, file, viewName);
    }

    public Integer updateState(Report report) {
        Integer currentState = report.getReportState();
        if (currentState.equals(1)) {
            Date deadline = report.getSubject().getFirstReportDeadline();
            if (report.getReportType().equals(2)) {
                deadline = report.getSubject().getLastReportDeadline();
            }
            if (DateUtil.between(new Date(), deadline, DateUnit.MS) > 0) {
                currentState = 2;
            } else {
                currentState = 3;
            }
        } else if (currentState.equals(5)) {
            currentState = 6;
        }
        return currentState;
    }
}
