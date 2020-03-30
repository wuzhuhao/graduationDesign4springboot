package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.ScoreRecord;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.AdminService;
import com.graduationaldesign.graduation.service.FileUploadService;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.service.TeacherService;
import com.graduationaldesign.graduation.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/24 20:16
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AdminService adminService;
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    ScoreRecordServiceImpl scoreRecordService;

    @Override
    public String singleFile(MultipartFile file, String path) throws RuntimeException {
        //判断非空
        if (file.isEmpty()) {
            throw new RuntimeException("上传的文件不能为空");
        }
        try {
            // 测试MultipartFile接口的各个方法
            log.info("[文件类型ContentType] - [{}]", file.getContentType());
            log.info("[文件组件名称Name] - [{}]", file.getName());
            log.info("[文件原名称OriginalFileName] - [{}]", file.getOriginalFilename());
            log.info("[文件大小] - [{}]", file.getSize());
            log.info(this.getClass().getName() + "图片路径：" + path);
            File f = new File(path);
            //如果不存在该路径就创建
            if (!f.exists()) {
                f.mkdir();
            }
            File dir = new File(path + file.getOriginalFilename());
            // 文件写入
            file.transferTo(dir);
            return file.getOriginalFilename();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("上传单个文件失败");
        }
    }

    @Override
    public String multipleFiles(MultipartFile[] files) throws RuntimeException {
        if (null == files && files.length == 0) {
            throw new RuntimeException("上传的文件不能为空");
        }
        //设置上传文件路径
        String filePath = System.getProperty("user.dir") + "/upload/";
        log.info(this.getClass().getName() + "图片路径：" + filePath);
        File f = new File(filePath);
        //如果不存在该路径就创建
        if (!f.exists()) {
            f.mkdir();
        }
        for (MultipartFile mf : files) {
            //文件名称
            String filename = mf.getOriginalFilename();
            if (mf.isEmpty()) {
                return "文件名称：" + filename + "上传失败，原因是文件为空!";
            }
            File dir = new File(filePath + filename);
            try {
                //写入文件
                mf.transferTo(dir);
                log.info("文件名称：" + filename + "上传成功");
            } catch (IOException e) {
                log.error(e.toString(), e);
                throw new RuntimeException("文件名称：" + filename + "上传失败");
            }
        }
        return "多文件上传成功";
    }


    public void importUser(MultipartFile file, Integer type) throws Exception {
        if (type == null || type > 3 || type <= 0) {
            throw new Exception("请选择上传用户类型");
        }
        if (type.equals(1)) {
//解析excel，
            List<Student> lstStudent = FileUtil.importExcel(file, 1, 1, Student.class);
            lstStudent.stream().forEach(obj -> {
                obj.setStuPassword("123456");
            });
            try {
                studentService.insertListSelective(lstStudent);
            } catch (Exception e) {
                log.error(e.getMessage());
                log.error("批量插入{0}失败", rootPropeties.getStudent());
                throw new RuntimeException(
                        MessageFormat.format("批量插入{0}失败", rootPropeties.getStudent()));
            }
        } else if (type.equals(2)) {
            //解析excel，
            List<Teacher> lstTeacher = FileUtil.importExcel(file, 1, 1, Teacher.class);
            lstTeacher.stream().forEach(obj -> obj.setTeaPassword("tea123456"));
            try {
                teacherService.insertListSelective(lstTeacher);
            } catch (Exception e) {
                log.error(e.getMessage());
                log.error("批量插入{0}失败", rootPropeties.getTeacher());
                throw new RuntimeException(
                        MessageFormat.format("批量插入{0}失败", rootPropeties.getTeacher()));
            }
        } else if (type.equals(3)) {
            //解析excel，
            List<Admin> lstAdmin = FileUtil.importExcel(file, 1, 1, Admin.class);
            lstAdmin.stream().forEach(obj -> obj.setAdminPassword("123456"));
            try {
                adminService.insertListSelective(lstAdmin);
            } catch (Exception e) {
                log.error(e.getMessage());
                log.error("批量插入{0}失败", rootPropeties.getAdmin());
                throw new RuntimeException(
                        MessageFormat.format("批量插入{0}失败", rootPropeties.getAdmin()));
            }
        }
    }

    @Override
    public void importReplyScore(MultipartFile file) {
        List<ScoreRecord> scoreRecordList = FileUtil.importExcel(file, 1, 1, ScoreRecord.class);
        scoreRecordService.updateListByPrimaryKeySelective(scoreRecordList);
//        scoreRecordService.insertSelectiveList(scoreRecordList);
    }

    public void deleteFile(String path, String name) {
        File file = new File(path + name);
        if (file.exists()) {
            file.delete();
        }
    }
}
