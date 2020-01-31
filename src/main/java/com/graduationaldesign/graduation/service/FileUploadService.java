package com.graduationaldesign.graduation.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/24 20:16
 */
public interface FileUploadService {
    String singleFile(MultipartFile file);
    String multipleFiles(MultipartFile[] files);
}
