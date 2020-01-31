package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.service.FileDownService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/24 20:14
 */
public class FileDownServiceImpl implements FileDownService {
    @Override
    public String singleFile(MultipartFile file) {
        return null;
    }

    @Override
    public String multipleFiles(MultipartFile[] files) {
        return null;
    }
}
