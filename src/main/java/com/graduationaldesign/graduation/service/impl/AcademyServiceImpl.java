package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.AcademyMapper;
import com.graduationaldesign.graduation.pojo.Academy;
import com.graduationaldesign.graduation.pojo.AcademyExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.AcademyService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: wuzhuhao
 * @Date: 2020/2/19 23:55
 */
@Service
public class AcademyServiceImpl implements AcademyService {

    @Resource
    private AcademyMapper academyMapper;
    @Autowired
    RootPropeties rootPropeties;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return academyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        AcademyExample example = new AcademyExample();
        AcademyExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        academyMapper.deleteByExample(example);
    }

    @Override
    public int insert(Academy record) {
        return academyMapper.insert(record);
    }

    @Override
    public int insertSelective(Academy record) {
        return academyMapper.insertSelective(record);
    }

    @Override
    public Academy selectByPrimaryKey(Integer id) {
        return academyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Academy record) {
        return academyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Academy record) {
        return academyMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<Academy> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<Academy> pageBean = new PageBean<>();
        AcademyExample example = new AcademyExample();
        AcademyExample.Criteria criteria = example.createCriteria();
        ExampleHelper.searchJoin(Academy.class, example, criteria, params);
        ExampleHelper.addCondition(Academy.class, criteria, params);
        List<Academy> list = this.academyMapper.selectByExampleWithBLOBs(example);
        pageBean.setBeanList(list);
        return pageBean;
    }

    @Override
    public Map<Integer, String> getItems() {
        AcademyExample example = new AcademyExample();
        example.setOrderByClause("id");
        List<Academy> list = academyMapper.selectByExample(example);
        Map<Integer, String> map = list.stream()
                .collect(Collectors.toMap(Academy::getId, Academy::getAcaName));
        return map;
    }

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Academy> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getAcademy());
        try {
            academyMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getAcademy());
        }
        return ResponseStatus.success(message, this);
    }
}
