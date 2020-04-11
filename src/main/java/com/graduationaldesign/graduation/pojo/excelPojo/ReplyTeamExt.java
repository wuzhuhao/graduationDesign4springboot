package com.graduationaldesign.graduation.pojo.excelPojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wuzhuhao
 * @Date: 2020/4/11 0011 15:12
 */
@Data
@JsonIgnoreProperties(value = {"handler"})
@ExcelTarget("replyTeamExt")
public class ReplyTeamExt implements Serializable {
    @Excel(name = "导师ID*")
    private String teaId;


    @Excel(name = "导师姓名")
    private String teaName;

    private static final long serialVersionUID = 1L;

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public ReplyTeamExt(String teaId, String teaName) {
        this.teaId = teaId;
        this.teaName = teaName;
    }

    public ReplyTeamExt() {
    }
}
