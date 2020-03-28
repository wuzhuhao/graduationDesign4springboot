package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.DesignShowMapper;
import com.graduationaldesign.graduation.pojo.DesignShow;
import com.graduationaldesign.graduation.pojo.DesignShowExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.DesignShowService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:15
 */
@Service
public class DesignShowServiceImpl implements DesignShowService {

    @Resource
    private DesignShowMapper designShowMapper;
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    FileUploadServiceImpl fileUploadService;
    final String FILE_PATH = System.getProperty("user.dir") + "/upload/" + this.getClass().getName().substring(0, this.getClass().getName().indexOf("ServiceImpl")) + "/";


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return designShowMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DesignShow record) {
        return designShowMapper.insert(record);
    }

    @Override
    public int insertSelective(DesignShow record) {
        return designShowMapper.insertSelective(record);
    }

    @Override
    public DesignShow selectByPrimaryKey(Integer id) {
        return designShowMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DesignShow record) {
        return designShowMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DesignShow record) {
        return designShowMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<DesignShow> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<DesignShow> pageBean = new PageBean<>();
        DesignShowExample example = new DesignShowExample();
        DesignShowExample.Criteria criteria = example.createCriteria();
        ExampleHelper.searchJoin(DesignShow.class, example, criteria, params);
        ExampleHelper.addCondition(DesignShow.class, criteria, params);
        List<DesignShow> list = this.designShowMapper.selectByExampleWithBLOBs(example);
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        DesignShowExample example = new DesignShowExample();
        DesignShowExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        designShowMapper.deleteByExample(example);
    }

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<DesignShow> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getDesignShow());
        try {
            designShowMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getDesignShow());
        }
        return ResponseStatus.success(message);
    }

    @Override
    public void uploadFile(MultipartFile file, Integer showId) {
        DesignShow designShow = new DesignShow(showId);
        designShow.setShowFile(fileUploadService.singleFile(file, FILE_PATH));
        try {
            designShowMapper.updateByPrimaryKeySelective(designShow);
        } catch (Exception e) {
            e.printStackTrace();
            fileUploadService.deleteFile(FILE_PATH, designShow.getShowFile());
            throw new RuntimeException("上传失败");
        }
    }
}
