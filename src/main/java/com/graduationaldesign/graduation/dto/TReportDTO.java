package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.util.Date;
import java.io.Serializable;


public class TReportDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        
        private Integer id;
        /**报告内容（使用富文本编辑）*/
        private String reportContent;
        /**报告提交时间*/
        private Date reportSubtime;
        /**状态：1是未提交，2是已提交，3是延期提交，4是通过，5是驳回待修改，6是已修改*/
        private Integer reportState;
        /**版本信息，默认是0*/
        private Float reportVersion;
        /**学生提交反馈信息*/
        private String stuMessage;
        /**导师意见*/
        private String teaSuggestion;
        /**报告附件*/
        private String reportFile;
        
        public Integer getId() {
            return this.id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getReportContent() {
            return this.reportContent;
        }
        
        public void setReportContent(String reportContent) {
            this.reportContent = reportContent;
        }
        
        public Date getReportSubtime() {
            return this.reportSubtime;
        }
        
        public void setReportSubtime(Date reportSubtime) {
            this.reportSubtime = reportSubtime;
        }
        
        public Integer getReportState() {
            return this.reportState;
        }
        
        public void setReportState(Integer reportState) {
            this.reportState = reportState;
        }
        
        public Float getReportVersion() {
            return this.reportVersion;
        }
        
        public void setReportVersion(Float reportVersion) {
            this.reportVersion = reportVersion;
        }
        
        public String getStuMessage() {
            return this.stuMessage;
        }
        
        public void setStuMessage(String stuMessage) {
            this.stuMessage = stuMessage;
        }
        
        public String getTeaSuggestion() {
            return this.teaSuggestion;
        }
        
        public void setTeaSuggestion(String teaSuggestion) {
            this.teaSuggestion = teaSuggestion;
        }
        
        public String getReportFile() {
            return this.reportFile;
        }
        
        public void setReportFile(String reportFile) {
            this.reportFile = reportFile;
        }
        
        public Report toModel() {
            Report model = new Report();
			BeanUtil.convert(this, model);
			return model;
        }
    
}