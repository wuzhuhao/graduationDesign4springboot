package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.SysdictMapper;
import com.graduationaldesign.graduation.pojo.Sysdict;
import com.graduationaldesign.graduation.pojo.SysdictExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.SysdictService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.*;
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
    public Map<String, Object> selectByModel(String Modelvalue) {
        Map<String, Object> map = new HashMap<>();
        Map<Long, String> p_name_map = new HashMap<>();
        //查出model_id
        SysdictExample example = new SysdictExample();
        SysdictExample.Criteria criteria = example.createCriteria();
        criteria.andDictTypeEqualTo("model");
        if (!Modelvalue.equals("all")) {
            criteria.andDictValueEqualTo(Modelvalue);
        }
        List<Long> pId = new ArrayList<>();
        pId.add(0L);
        try {
            List<Sysdict> sysdictList = sysdictMapper.selectByExample(example);
            p_name_map = sysdictList.stream().collect(Collectors.toMap(Sysdict::getId, Sysdict::getDictValue));
            pId.addAll(sysdictList.stream().map(e -> e.getId()).collect(Collectors.toList()));
        } catch (IndexOutOfBoundsException e) {
            log.error("无数据，默认不输出");
            pId = Arrays.asList(0L);
        }
        //查出所有item_id
        example = new SysdictExample();
        criteria = example.createCriteria();
        criteria.andDictParentidIn(pId);
        criteria.andDictTypeEqualTo("item");
        List<Sysdict> itemList = sysdictMapper.selectByExample(example);
        for (Sysdict sysdict : itemList) {
            String modelName = p_name_map.get(sysdict.getDictParentid());
            Map<String, Map> map1 = (Map<String, Map>) map.get(modelName);
            if (map.get(modelName) == null) {
                map1 = new HashMap<>();
            }
            Long id = sysdict.getId();
            String name = sysdict.getDictValue();
            example = new SysdictExample();
            criteria = example.createCriteria();
            criteria.andDictParentidEqualTo(id);
            criteria.andDictTypeEqualTo("dict");
            List<Sysdict> sysdictList = sysdictMapper.selectByExample(example);
            map1.put(name, sysdictList.stream().collect(Collectors.toMap(Sysdict::getDictValue, Sysdict::getDictText)));
            map.put(modelName, map1);
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
        return ResponseStatus.success(message);
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Long> lstPrimaryKey) throws Exception {
        SysdictExample example = new SysdictExample();
        SysdictExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        sysdictMapper.deleteByExample(example);
    }


    @Override
    public PageBean<Sysdict> listByPage(HashMap<String, Object> params, int page, int pageSize) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<Sysdict> pageBean = new PageBean<>();
        SysdictExample example = new SysdictExample();
        SysdictExample.Criteria criteria = example.createCriteria();
        ExampleHelper.searchJoin(Sysdict.class, example, criteria, params);
        ExampleHelper.addCondition(Sysdict.class, criteria, params);
        List<Sysdict> list = this.sysdictMapper.selectByExample(example);
        pageBean.setBeanList(list);
        return pageBean;
    }

}
