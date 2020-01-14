package com.graduationaldesign.graduation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduationaldesign.graduation.service.DiaryService;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/10 21:55
 */
//@Service
public class DiaryServiceImpl implements DiaryService {
//    @Autowired
//    DiaryMapper diaryMapper;
//    @Override
//    public PageBean<Diary> listByPage(int uid, int page) {
//        int totalpage;
//        long diarySize;
//        PageBean<Diary> pageBean = new PageBean<Diary>();
//        DiaryExample diaryExample = new DiaryExample();
//        DiaryExample.Criteria criteria = diaryExample.createCriteria();
//        if (uid!=0){
//            criteria.andDidEqualTo(uid);
//            Map<String,Object> param = new HashMap<String, Object>();
//            param.put("uid",uid);
//            pageBean.setParams(param);
//        }
//        diaryExample.setOrderByClause("dTime desc");
//        diarySize = diaryMapper.countByExample(diaryExample);
//        pageBean.setPageSize(DiaryMapper.PAGE_SIZE);
//        pageBean.setTotalRecord((int) diarySize);
//        totalpage = pageBean.getTotalPage();
//        //页数大于时选最后一页
//        page = (page<=0)?1:page>totalpage?totalpage:page;
//        PageHelper.startPage(page , DiaryMapper.PAGE_SIZE);
//        List<Diary> list =  diaryMapper.selectByExample(diaryExample);
//        //得到分页的结果对象
//        PageInfo<Diary> personPageInfo = new PageInfo<Diary>(list);
//        //得到分页中的person条目对象
//        List<Diary> pageList = personPageInfo.getList();
//        pageBean.setBeanList(pageList);
//        return pageBean;
//    }
}
