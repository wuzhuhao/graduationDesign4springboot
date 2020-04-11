package com.graduationaldesign.graduation.controller.file;

import com.graduationaldesign.graduation.controller.Api;
import com.graduationaldesign.graduation.service.impl.FileUploadServiceImpl;
import com.graduationaldesign.graduation.util.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wuzhuhao
 * @description 单文件和多文件的上传
 **/
@RestController
@Slf4j
@RequestMapping("/uploadFile")
@Api(Pojo = "FileUpload", description = "文件上传控制层")
public class FileUploadController {

    @Autowired
    FileUploadServiceImpl fileUploadService;


    @PostMapping("/singleFile")
    public ResponseEntity<Object> singleFile(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseStatus.success(fileUploadService.singleFile(file, "/"), this);
        } catch (RuntimeException e) {
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @PostMapping("/multipleFiles")
    public String multipleFiles(@RequestParam("file") MultipartFile[] files) {
        try {
            return fileUploadService.multipleFiles(files);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("/importUserByExcel")
    public ResponseEntity<Object> importStudentByExcel(@RequestParam("file") MultipartFile file,
                                                       Integer type) {
        try {
            fileUploadService.importUser(file, type);
            return ResponseStatus.success("导入数据成功", this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure(e.getMessage(), this);
        }
    }

    @RequestMapping("/importReplyScoreByExcel")
    public ResponseEntity<Object> importReplyScoreByExcel(@RequestParam("file") MultipartFile file) {
        try {
            fileUploadService.importReplyScore(file);
            return ResponseStatus.success("导入答辩数据成功", this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("导入答辩数据失败", this);
        }
    }

    @RequestMapping("/importReplyTeamByExcel")
    public ResponseEntity<Object> importReplyTeamByExcel(@RequestParam("file") MultipartFile file) {
        try {
            fileUploadService.importReplyTeam(file);
            return ResponseStatus.success("导入答辩数据成功", this);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("导入答辩数据失败", this);
        }
    }
}
