package com.graduationaldesign.graduation.controller.file;

import com.graduationaldesign.graduation.controller.Api;
import com.graduationaldesign.graduation.pojo.Progress;
import com.graduationaldesign.graduation.pojo.Task;
import com.graduationaldesign.graduation.service.FileDownService;
import com.graduationaldesign.graduation.service.TaskService;
import com.graduationaldesign.graduation.service.impl.ScoreRecordServiceImpl;
import com.graduationaldesign.graduation.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wuzhuhao
 * @description 单文件和多文件下载
 **/
@Controller
@Slf4j
@RequestMapping("/downFile")
@Api(Pojo = "FileDown", description = "文件下载控制层")
public class FileDownController {

    @Autowired
    FileDownService fileDownService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    TaskService taskService;
    @Autowired
    ScoreRecordServiceImpl scoreRecordService;

    @GetMapping(value = "/downSingleFile")
    public ResponseEntity<Object> download(HttpServletResponse response, String fileName)
            throws UnsupportedEncodingException {
        String filePathName = fileName;
        File file = new File("upload/" + filePathName);
        if (!file.exists()) {
            return ResponseStatus.failure("文件不存在", this);
        }
        //使用URLEncoder解决中文变__问题
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode(filePathName, "utf-8"));
        try {
            InputStream inStream = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] buff = new byte[1024];
            int i = 0;
            //read方法返回读取到字节数，=0说明到达文件结尾，=-1说明发生错误
            while ((i = inStream.read(buff)) != -1) {
                //write()方法3个参数，可自定义读取字节数0-i;
                os.write(buff, 0, i);
            }
            os.flush();
            os.close();
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseStatus.failure("下载失败", this);
        }
        return ResponseStatus.success("下载成功", this);
    }

    @GetMapping("/downMultipleFiles")
    public ResponseEntity<Object> multipleFiles(HttpServletResponse response, String[] fileName)
            throws IOException {
        //1.创建临时文件夹
        String downPath = System.getProperty("user.dir") + "/downzip/";
        File f = new File(downPath);
        //如果不存在该路径就创建
        if (!f.exists()) {
            f.mkdir();
        }
        //2.将需要下载文件复制到临时文件夹
        for (int i = 0; i < fileName.length; i++) {
            String uploadPath = System.getProperty("user.dir") + "/upload/" + fileName[i];
            ZipUtils.copyFile(uploadPath, downPath + "/" + fileName[i]);
        }
        //3.设置response,设置压缩包名称
        response.setContentType("application/zip");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        String filename = format + "down.zip";
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        //4.调用工具类，下载zip
        ZipUtils.toZip(downPath, response.getOutputStream(), true);
        //5.删除临时文件夹
        File[] listFiles = f.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            listFiles[i].delete();
            log.info("正在删除第" + i + "个文件");
        }
        f.delete();
        return ResponseStatus.success("多文件下载成功", this);
    }

    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params;
        Task task = taskService.selectByPrimaryKey(3);
        params = BeanUtil.beanToMap(task);
        //这里是我说的一行代码
        FileUtil.exportWord("word/firstReport.docx", "F:/test", "123.docx", params, request, response);
    }

    //, int type, int isdemo
    @RequestMapping("/exportDemo")
    @ResponseBody
    public ResponseEntity<Object> exportDemo(HttpServletResponse response, Integer type) {
        ResponseEntity<Object> result = null;
        try {
            fileDownService.exportDemo(type, response);
            result = ResponseStatus.success("导出模板成功", this);
        } catch (RuntimeException e) {
            e.printStackTrace();
            result = ResponseStatus.failure(e.getMessage(), this);
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatus.failure("导出模板失败", this);
        }
        return result;
    }

    @RequestMapping("/exportScore")
    @ResponseBody
    public ResponseEntity<Object> exportScore(HttpServletResponse response) {
        ResponseEntity<Object> result = null;
        try {
            fileDownService.exportScore(response);
            result = ResponseStatus.success("导出答辩信息成功", this);
        } catch (RuntimeException e) {
            e.printStackTrace();
            result = ResponseStatus.failure(e.getMessage(), this);
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatus.failure("导出答辩信息失败", this);
        }
        return result;
    }


    @RequestMapping("/exportDemo1")
    @ResponseBody
    public ResponseEntity<Object> exportDemo1(HttpServletResponse response) {
        ResponseEntity<Object> result = null;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("stuName", "测试名称");
            map.put("stuId", "学号");
            map.put("stuClass", "班级");
            map.put("stuMajor", "专业");
            map.put("academyName", "学院名称");
            map.put("teaName", "教师名称");
            map.put("subName", "课题名称");
            List<Progress> list = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                Progress progress = new Progress();
                progress.setProgReply("回复" + i);
                progress.setProgContent("内容" + i);
                progress.setProgContentTime(new Date());
                map.put("num", i + "");
                map.put("progressTime", "日期" + i);
                map.put("progressContent", "指导内容" + i);
                map.put("replyContent", "回复内容" + i);
                list.add(progress);
            }
            map.put("listInfo", list);
            WordUtils.exportMillCertificateWord(request, response, map, "测试title", "progress.ftl");
            result = ResponseStatus.success("导出模板成功", this);
        } catch (RuntimeException e) {
            e.printStackTrace();
            result = ResponseStatus.failure(e.getMessage(), this);
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatus.failure("导出模板失败", this);
        }
        return result;
    }

}
