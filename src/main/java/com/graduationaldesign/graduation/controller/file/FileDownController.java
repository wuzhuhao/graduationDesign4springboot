package com.graduationaldesign.graduation.controller.file;

import com.graduationaldesign.graduation.pojo.Progress;
import com.graduationaldesign.graduation.service.FileDownService;
import com.graduationaldesign.graduation.util.FileUtil;
import com.graduationaldesign.graduation.util.ResponseStatu;
import com.graduationaldesign.graduation.util.WordUtils;
import com.graduationaldesign.graduation.util.ZipUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuzhuhao
 * @description 单文件和多文件下载
 **/
@RestController
@Slf4j
@RequestMapping("/downFile")
public class FileDownController {

    @Autowired
    FileDownService fileDownService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @GetMapping(value = "/downSingleFile")
    public ResponseEntity<Object> download(HttpServletResponse response, String fileName)
            throws UnsupportedEncodingException {
        String filePathName = fileName;
        File file = new File("upload/" + filePathName);
        if (!file.exists()) {
            return ResponseStatu.failure("文件不存在");
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
            return ResponseStatu.failure("下载失败");
        }
        return ResponseStatu.success("下载成功");
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
        return ResponseStatu.success("多文件下载成功");
    }

    @RequestMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", "这是标题");
        params.put("name", "李四");
        //这里是我说的一行代码
        FileUtil.exportWord("word/test.docx", "F:/test", "aaa.docx", params, request, response);
    }

    //, int type, int isdemo
    @RequestMapping("/exportDemo")
    @ResponseBody
    public ResponseEntity<Object> exportDemo(HttpServletResponse response, Integer type) {
        ResponseEntity<Object> result = null;
        try {
            fileDownService.exportDemo(type, response);
            result = ResponseStatu.success("导出模板成功");
        } catch (RuntimeException e) {
            e.printStackTrace();
            result = ResponseStatu.failure(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatu.failure("导出模板失败");
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
            result = ResponseStatu.success("导出模板成功");
        } catch (RuntimeException e) {
            e.printStackTrace();
            result = ResponseStatu.failure(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result = ResponseStatu.failure("导出模板失败");
        }
        return result;
    }

}
