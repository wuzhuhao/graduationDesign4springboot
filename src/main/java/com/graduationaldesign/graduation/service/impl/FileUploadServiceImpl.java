package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/24 20:16
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public String singleFile(MultipartFile file) throws RuntimeException{
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
            //文件路径
            String path = System.getProperty("user.dir") + "/upload/";
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
    public String multipleFiles(MultipartFile[] files) throws RuntimeException{
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
}
