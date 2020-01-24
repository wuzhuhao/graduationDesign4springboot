package com.graduationaldesign.graduation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduationaldesign.graduation.mapper.SubjectMapper;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Subject;
import com.graduationaldesign.graduation.pojo.SubjectExample;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.SubjectService;
import com.graduationaldesign.graduation.util.IDUtil;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:10
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;
    /*==============私有接口=====================*/
    private PageBean<Subject> pageByExample(SubjectExample subjectExample,int page){
        int totalpage;
        int totalSize;
        PageBean<Subject> pageBean = new PageBean<>();
        totalSize = (int) subjectMapper.countByExample(subjectExample);
        pageBean.setPageSize(SubjectMapper.PAGE_SIZE);
        pageBean.setTotalRecord(totalSize);
        totalpage = pageBean.getTotalPage();
        //页数大于时选最后一页
        page = (page<=0)?1:page>totalpage?totalpage:page;
        pageBean.setCurrentPage(page);
        PageHelper.startPage(page , SubjectMapper.PAGE_SIZE);
        List<Subject> list =  subjectMapper.selectByExample(subjectExample);
        //得到分页的结果对象
        PageInfo<Subject> personPageInfo = new PageInfo<>(list);
        //得到分页中的person条目对象
        List<Subject> pageList = personPageInfo.getList();
        pageBean.setBeanList(pageList);
        return pageBean;
    }

    /*==============公开接口=====================*/
    @Override
    public String deleteByPrimaryKey(String subId) {
        String message = "删除课题成功";
        if(subjectMapper.deleteByPrimaryKey(subId)<=0){
            message = "删除课题失败";
        }
        return message;
    }

    @Override
    public String insert(Subject record) {
        String message = "增加课题成功！";
        try {
            record.setSubId(IDUtil.generateSubID(record.getSubSource()));
        }catch (NullPointerException ne){
            message ="参数错误，请检查参数！";
        }
        if (subjectMapper.insert(record)<=0){
            message = "增加课题失败！";
        }
        return message;
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
    public String updateByPrimaryKeySelective(Subject record) {
        String message = "修改课题成功";
        if (subjectMapper.updateByPrimaryKeySelective(record)<=0){
            message = "修改课题失败";
        }
        return message;
    }

    @Override
    public int updateByPrimaryKey(Subject record) {
        return subjectMapper.updateByPrimaryKey(record);
    }


    /**
     * 选题service层
     * @param subId
     * @return
     */
    public String ChoiceSubject(String subId, Student student) {
        Subject subject = subjectMapper.selectByPrimaryKey(subId);
        String message = "选定课题成功";
        if (subject==null||subject.getSubStuState()==null||(!subject.getSubStuState().equals(1))){
            return "选定课题失败，请刷新页面";
        }
        subject.setSubStuState(2);
        subject.setStuId(student.getStuId());
        if (subjectMapper.updateByPrimaryKey(subject)<=0){
            message = "选定课题失败，请刷新页面";
        }
        return message;
    }

    public String cancelChoice(String subId, Student student) {
        Subject subject = subjectMapper.selectByPrimaryKey(subId);
        String message = "取消选定课题成功";
        try {
            if (subject.getSubStuState().equals(1)){
                return "取消选定课题失败，请刷新页面";
            }
            else if (!subject.getStuId().equals(student.getStuId())){
                return "取消选定课题失败，请刷新页面";
            }
        } catch (NullPointerException e) {
            return "取消选定课题失败，请刷新页面";
        }
        subject.setSubStuState(1);
        subject.setStuId(null);
        if (subjectMapper.updateByPrimaryKey(subject)<=0){
            message = "取消选定课题失败，请刷新页面";
        }
        return message;
    }

    /**
     * 选题列表service层
     * @param params
     * @param page
     * @return
     */
    public PageBean<Subject> listByPageOfNotChoice(HashMap<String, Object> params, int page) {
        PageBean<Subject> pageBean;
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
//        if (uid!=0){
//            criteria.andDidEqualTo(uid);
//            Map<String,Object> param = new HashMap<String, Object>();
//            param.put("uid",uid);
//            pageBean.setParams(param);
//        }
//        diaryExample.setOrderByClause("dTime desc");
        criteria.andSubStuStateEqualTo(1);
//        pageBean.setParams();
        pageBean = pageByExample(subjectExample,page);
        return pageBean;
    }

    /**
     *获取已选列表service层
     * @param param
     * @param page
     * @return
     */
    public PageBean<Subject> listByPageOfChoice(Map<String,Object> param,int page,Student student) {
        PageBean<Subject> pageBean;
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
        criteria.andStuIdEqualTo(student.getStuId());
        criteria.andSubStuStateNotEqualTo(1);
        pageBean = pageByExample(subjectExample,page);
//        pageBean.setParams();
        return pageBean;
    }

    public PageBean<Subject> listByPageOfTea(HashMap<String, Object> params, int page, Teacher teacher) {
        PageBean<Subject> pageBean;
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
        criteria.andSubTeaIdEqualTo(teacher.getTeaId());
        criteria.andSubStuStateNotEqualTo(1);
        pageBean = pageByExample(subjectExample,page);
//        pageBean.setParams();
        return pageBean;
    }

    public PageBean<Subject> listByPage(HashMap<String, Object> params, int page) {
        PageBean<Subject> pageBean;
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
        pageBean = pageByExample(subjectExample,page);
//        pageBean.setParams();
        return pageBean;
    }
}
