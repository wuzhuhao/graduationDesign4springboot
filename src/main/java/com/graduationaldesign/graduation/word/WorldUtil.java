package com.graduationaldesign.graduation.word;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.Map;

/**
 * world工具类
 *
 * @author cheny
 * @version 1.0
 * @create 2019-02-13 17:13
 **/
public class WorldUtil {

    /**
     * 导出world
     * @param dataMap 数据集
     * @param templateName 模板名称
     * @param filePath 模板路径
     * @param fileName 文件名
     * @param response
     */
    public static void exportDoc(Map dataMap, String templateName, String filePath, String fileName, HttpServletResponse response){
        try {
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("UTF-8");
            //设置模板所在文件夹
            configuration.setDirectoryForTemplateLoading(new File(filePath));
            //获取模板
            Template template = configuration.getTemplate(templateName);
            // 告诉浏览器用什么软件可以打开此文件
            response.setHeader("Content-disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName + ".doc", "UTF-8"));
            response.setContentType("application/msword");// 定义输出类型
            template.process(dataMap, new OutputStreamWriter(response.getOutputStream()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}


