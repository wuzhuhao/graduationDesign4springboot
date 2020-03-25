package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.SysdictMapper;
import com.graduationaldesign.graduation.pojo.Sysdict;
import com.graduationaldesign.graduation.pojo.SysdictExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.SysdictService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatu;
import lombok.extern.slf4j.Slf4j;
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
 * @Date: 2020/3/22 0022 15:46
 */
@Service
@Slf4j
public class SysdictServiceImpl implements SysdictService {

    @Resource
    private SysdictMapper sysdictMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysdictMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Sysdict record) {
        return sysdictMapper.insert(record);
    }

    @Override
    public int insertSelective(Sysdict record) {
        return sysdictMapper.insertSelective(record);
    }

    @Override
    public Sysdict selectByPrimaryKey(Long id) {
        return sysdictMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Map<Object, String>> selectByModel(String Modelvalue) {
        Map<String, Map<Object, String>> map = new HashMap<>();
        //查出model_id
        SysdictExample example = new SysdictExample();
        SysdictExample.Criteria criteria = example.createCriteria();
        criteria.andDictTypeEqualTo("model");
        if (!Modelvalue.equals("all")) {
            criteria.andDictValueEqualTo(Modelvalue);
        }
        Long pId;
        try {
            pId = sysdictMapper.selectByExample(example).get(0).getId();
        } catch (IndexOutOfBoundsException e) {
            log.error("无数据，默认不输出");
            pId = 0L;
        }
        //查出所有item_id
        example = new SysdictExample();
        criteria = example.createCriteria();
        criteria.andDictParentidEqualTo(pId);
        criteria.andDictTypeEqualTo("item");
        List<Sysdict> itemList = sysdictMapper.selectByExample(example);
        for (Sysdict sysdict : itemList) {
            Long id = sysdict.getId();
            String name = sysdict.getDictValue();
            example = new SysdictExample();
            criteria = example.createCriteria();
            criteria.andDictParentidEqualTo(id);
            criteria.andDictTypeEqualTo("dict");
            List<Sysdict> sysdictList = sysdictMapper.selectByExample(example);
            map.put(name, sysdictList.stream().collect(Collectors.toMap(Sysdict::getDictValue, Sysdict::getDictText)));
        }
        return map;
    }

    @Override
    public int updateByPrimaryKeySelective(Sysdict record) {
        return sysdictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Sysdict record) {
        return sysdictMapper.updateByPrimaryKey(record);
    }

    @Autowired
    RootPropeties rootPropeties;

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Sysdict> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getSysdict());
        try {
            sysdictMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getSysdict());
        }
        return ResponseStatu.success(message);
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Long> lstPrimaryKey) throws Exception {
        SysdictExample example = new SysdictExample();
        SysdictExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        sysdictMapper.deleteByExample(example);
    }


    @Override
    public PageBean<Sysdict> listByPage(HashMap<String, Object> params, int page, int pageSize) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Sysdict> pageBean = new PageBean<>();
        SysdictExample example = new SysdictExample();
        SysdictExample.Criteria criteria = example.createCriteria();
        ExampleHelper.addCondition(Sysdict.class, criteria, params);
        List<Sysdict> list = this.sysdictMapper.selectByExample(example);
        pageBean.setBeanList(list);
        return pageBean;
    }

}
