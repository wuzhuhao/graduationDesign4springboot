package com.graduationaldesign.graduation.util;


import cn.hutool.core.date.DateUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wuzhuhao
 * @Date: 2020/3/1 22:36
 */
public class WordUtils {

    private static Configuration configuration = null;
    //classLoader.getResource()只能获取相对路径的资源
//     private static final String templateFolder = WordUtils.class.getClassLoader().getResource("template").getPath();
    //class.getResource()可以获取绝对路径和相对路径
    private static final String templateFolder = WordUtils.class.getResource("/freeMarker")
            .getPath();


    static {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        try {
            configuration.setDirectoryForTemplateLoading(new File(templateFolder));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private WordUtils() {
        throw new AssertionError();
    }

    public static void exportMillCertificateWord(HttpServletRequest request,
            HttpServletResponse response, Map map, String title, String ftlFile)
            throws IOException {
        Template freemarkerTemplate = configuration.getTemplate(ftlFile);
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            // 调用工具类的createDoc方法生成Word文档
            file = createDoc(map, freemarkerTemplate);
            clearFile(file);
            fin = new FileInputStream(file);

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            // 设置浏览器以下载的方式处理该文件名
            String fileName = title + DateUtil.now() + ".doc";
            response.setHeader("Content-Disposition", "attachment;filename="
                    .concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));

            out = response.getOutputStream();
            byte[] buffer = new byte[512];  // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                fin.close();
            }
            if (out != null) {
                out.close();
            }
            if (file != null) {
                file.delete(); // 删除临时文件
            }
        }
    }

    private static File createDoc(Map<?, ?> dataMap, Template template) {
        String name = "sellPlan.doc";
        File f = new File(name);
        Template t = template;
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }

    public static void clearFile(File file) throws Exception {
        writeFile(clearHtmlCode(fileRead(file)));
    }

    public static void writeFile(String str) {
        FileWriter writer;
        try {
            writer = new FileWriter("E:/token.txt");
            writer.write("");//清空原文件内容
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fileRead(File file) throws Exception {
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s = bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
        }
        bReader.close();
        String str = sb.toString();
        return str;
    }

    public static String clearHtmlCode(String htmlCode) {
        htmlCode = htmlCode.replaceAll("\t", "").replaceAll("\r\n", "").replaceAll("\n", "");
        htmlCode = htmlCode.replaceAll("<SCRIPT(.[^(</SCRIPT>)]*)</SCRIPT>", "");
        htmlCode = htmlCode.replaceAll("<script(.[^(</script>)]*)</script>", "");
        htmlCode = htmlCode.replaceAll("<(.[^>]*)>", "");
        htmlCode = htmlCode.replaceAll("&nbsp;", "");
        return filter(htmlCode);
    }

    public static String filter(String value) {
        if (value == null || value.length() == 0) {
            return value;
        }
        StringBuffer result = null;
        String filtered = null;
        for (int i = 0; i < value.length(); i++) {
            filtered = null;
            switch (value.charAt(i)) {
                case 60: // '<'
                    filtered = "&lt;";
                    break;
                case 62: // '>'
                    filtered = "&gt;";
                    break;
                case 38: // '&'
                    filtered = "&amp;";
                    break;
                case 34: // '"'
                    filtered = "&quot;";
                    break;
                case 39: // '\''
                    filtered = "'";
                    break;
            }
            if (result == null) {
                if (filtered != null) {
                    result = new StringBuffer(value.length() + 50);
                    if (i > 0) {
                        result.append(value.substring(0, i));
                    }
                    result.append(filtered);
                }
            } else if (filtered == null) {
                result.append(value.charAt(i));
            } else {
                result.append(filtered);
            }
        }
        return result != null ? result.toString() : value;
    }
}
