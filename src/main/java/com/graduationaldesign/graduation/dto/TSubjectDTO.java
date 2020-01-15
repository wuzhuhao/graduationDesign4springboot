package com.graduationaldesign.graduation.dto;

import java.math.BigDecimal;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.util.Date;
import com.graduationaldesign.graduation.pojo.Subject;
import java.io.Serializable;


public class TSubjectDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**课题名称*/
        private String subName;
        /**课题性质，1是理论性课题，2是实践性课题*/
        private Integer subNature;
        /**课程来源，1是科研题目，2是企业题目，3是自拟题目*/
        private Integer subSource;
        /**课题介绍*/
        private String subIntroduce;
        /**课题导师，外键对教师表*/
        private String subTeaId;
        /**课题附件*/
        private String subFile;
        /**开题报告最后的时间*/
        private Date firstReportDeadline;
        /**论文定稿最后时间*/
        private Date lastReportDeadline;
        /**学生id，外键对学生表*/
        private String stuId;
        /**选定状态，1是待选定，2是待审核，3是通过*/
        private Integer subStuState;
        /**最终评分*/
        private BigDecimal subLastScore;
        /**展示id，外键展示表id*/
        private Integer showId;
        
        public String getSubName() {
            return this.subName;
        }
        
        public void setSubName(String subName) {
            this.subName = subName;
        }
        
        public Integer getSubNature() {
            return this.subNature;
        }
        
        public void setSubNature(Integer subNature) {
            this.subNature = subNature;
        }
        
        public Integer getSubSource() {
            return this.subSource;
        }
        
        public void setSubSource(Integer subSource) {
            this.subSource = subSource;
        }
        
        public String getSubIntroduce() {
            return this.subIntroduce;
        }
        
        public void setSubIntroduce(String subIntroduce) {
            this.subIntroduce = subIntroduce;
        }
        
        public String getSubTeaId() {
            return this.subTeaId;
        }
        
        public void setSubTeaId(String subTeaId) {
            this.subTeaId = subTeaId;
        }
        
        public String getSubFile() {
            return this.subFile;
        }
        
        public void setSubFile(String subFile) {
            this.subFile = subFile;
        }
        
        public Date getFirstReportDeadline() {
            return this.firstReportDeadline;
        }
        
        public void setFirstReportDeadline(Date firstReportDeadline) {
            this.firstReportDeadline = firstReportDeadline;
        }
        
        public Date getLastReportDeadline() {
            return this.lastReportDeadline;
        }
        
        public void setLastReportDeadline(Date lastReportDeadline) {
            this.lastReportDeadline = lastReportDeadline;
        }
        
        public String getStuId() {
            return this.stuId;
        }
        
        public void setStuId(String stuId) {
            this.stuId = stuId;
        }
        
        public Integer getSubStuState() {
            return this.subStuState;
        }
        
        public void setSubStuState(Integer subStuState) {
            this.subStuState = subStuState;
        }
        
        public BigDecimal getSubLastScore() {
            return this.subLastScore;
        }
        
        public void setSubLastScore(BigDecimal subLastScore) {
            this.subLastScore = subLastScore;
        }
        
        public Integer getShowId() {
            return this.showId;
        }
        
        public void setShowId(Integer showId) {
            this.showId = showId;
        }
        
        public Subject toModel() {
            Subject model = new Subject();
			BeanUtil.convert(this, model);
			return model;
        }
    
}