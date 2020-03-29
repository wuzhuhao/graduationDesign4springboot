package com.graduationaldesign.graduation.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/24 20:12
 */
public interface FileDownService {

    String singleFile(MultipartFile file);

    String multipleFiles(MultipartFile[] files);

    void exportDemo(Integer type, HttpServletResponse response);

    public ResponseEntity<Object> download(HttpServletResponse response, String fileName) throws UnsupportedEncodingException;
}
