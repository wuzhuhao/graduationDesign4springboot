package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.pojo.*;
import com.graduationaldesign.graduation.pojo.excelPojo.ReplyTeamExt;
import com.graduationaldesign.graduation.pojo.excelPojo.ReplyTeamModel;
import com.graduationaldesign.graduation.service.FileDownService;
import com.graduationaldesign.graduation.util.FileUtil;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/24 20:14
 */
@Service
public class FileDownServiceImpl implements FileDownService {
    @Autowired
    ScoreRecordServiceImpl scoreRecordService;

    @Override
    public String singleFile(MultipartFile file) {
        return null;
    }

    @Override
    public String multipleFiles(MultipartFile[] files) {
        return null;
    }

    @Override
    public void exportDemo(Integer type, HttpServletResponse response) {
        if (type == null) {
            throw new RuntimeException("请选择模板类型");
        }
        if (type.equals(1)) {
            FileUtil.exportExcel(new ArrayList<>(), "学生导入模板", "中山大学南方学院", Student.class,
                    "学生导入模板.xls",
                    response);
        } else if (type.equals(2)) {
            ArrayList<Teacher> teacherArrayList = new ArrayList<>();
            FileUtil.exportExcel(teacherArrayList, "教师导入模板", "中山大学南方学院", Teacher.class,
                    "教师导入模板.xls",
                    response);
        } else if (type.equals(3)) {
            FileUtil.exportExcel(new ArrayList<>(), "管理员导入模板", "中山大学南方学院", Admin.class,
                    "管理员导入模板.xls",
                    response);
        } else {
            throw new RuntimeException("请选择模板类型");
        }
    }


    @Override
    public ResponseEntity<Object> download(HttpServletResponse response, String fileName, String viewName) throws UnsupportedEncodingException {
        String filePathName = fileName;
        File file = new File(filePathName);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
//            return ResponseStatus.failure("文件不存在", this);
        }
        //使用URLEncoder解决中文变__问题
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode(FileUtil.getViewFileName(fileName, viewName), "utf-8"));
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
            throw new RuntimeException("下载失败");
//            return ResponseStatus.failure("下载失败", this);
        }
        return ResponseStatus.success("下载成功");
    }

    @Override
    public void exportScore(HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<ScoreRecord> scoreRecordList = scoreRecordService.selectByParam(new HashMap<>());
        for (int i = 0; i < scoreRecordList.size(); i++) {
            ScoreRecord scoreRecord = scoreRecordList.get(i);
            scoreRecord.getSubject();
            ReplyTeam replyTeam = scoreRecord.getReplyTeam();
            replyTeam.setTeamLeaderId(replyTeam.getTeacher().getTeaName());
            scoreRecord.setReplyTeam(replyTeam);
            scoreRecordList.set(i, scoreRecord);
        }
        FileUtil.exportExcel(scoreRecordList, "答辩信息表", "中山大学南方学院", ScoreRecord.class, "答辩信息表.xls", response);
    }

    @Override
    public void exportReplyTeamDemo(HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<ReplyTeamModel> lstReplyTeamModel = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ReplyTeamModel replyTeamModel = new ReplyTeamModel("答辩小组名称" + i, "答辩地址" + i, new Date(), "答辩小组组长编号" + i, "答辩关联课题编号" + i);
            replyTeamModel.setId(0);
            List<ReplyTeamExt> lstReplyTeamExt = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                ReplyTeamExt replyTeamExt = new ReplyTeamExt("导师编号" + j, "导师名称" + j);
                lstReplyTeamExt.add(replyTeamExt);
            }
            replyTeamModel.setLstReplyTeamExt(lstReplyTeamExt);
            lstReplyTeamModel.add(replyTeamModel);
        }
        FileUtil.exportExcel(lstReplyTeamModel, "答辩小组信息表", "中山大学南方学院", ReplyTeamModel.class, "答辩小组批量导入模板.xls", response);
    }
}
