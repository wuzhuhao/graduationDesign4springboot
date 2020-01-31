package com.graduationaldesign.graduation.controller.file;

import com.graduationaldesign.graduation.util.ResponseStatu;
import com.graduationaldesign.graduation.util.ZipUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wuzhuhao
 * @description 单文件和多文件下载
 **/
@RestController
@Slf4j
public class FileDownController {
    @GetMapping(value = "/downSingleFile")
    public ResponseEntity<Object> download(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
        String filePathName = fileName;
        File file = new File("upload/" + filePathName);
        if (!file.exists()) {
            return ResponseStatu.failure("文件不存在");
        }
        //使用URLEncoder解决中文变__问题
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filePathName, "utf-8"));
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
    public ResponseEntity<Object> multipleFiles(HttpServletResponse response, String[] fileName) throws IOException {
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
}
