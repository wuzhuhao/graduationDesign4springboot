package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.FileDownService;
import com.graduationaldesign.graduation.util.FileUtil;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/24 20:14
 */
@Service
public class FileDownServiceImpl implements FileDownService {

    @Override
    public String singleFile(MultipartFile file) {
        return null;
    }

    @Override
    public String multipleFiles(MultipartFile[] files) {
        return null;
    }

    @Override
    public void exportDemo(int type, HttpServletResponse response) {
        if (type == 1) {
            FileUtil.exportExcel(new ArrayList<>(), "学生导入模板", "中山大学南方学院", Student.class, "导入模板.xls",
                    response);
        } else if (type == 2) {
            FileUtil.exportExcel(new ArrayList<>(), "教师导入模板", "中山大学南方学院", Teacher.class, "导入模板.xls",
                    response);
        } else if (type == 3) {
            FileUtil.exportExcel(new ArrayList<>(), "管理员导入模板", "中山大学南方学院", Admin.class, "导入模板.xls",
                    response);
        } else {
            throw new RuntimeException("请选择模板类型");
        }
    }

}
