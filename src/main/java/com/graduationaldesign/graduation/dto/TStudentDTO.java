package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.io.Serializable;


public class TStudentDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**学生登陆密码*/
        private String stuPassword;
        /**学生名称*/
        private String stuName;
        /**学生专业*/
        private String stuMajor;
        /**学生班级*/
        private String stuClass;
        /**学生年龄*/
        private String stuSex;
        /**学生年龄*/
        private Integer stuAge;
        /**学生生日*/
        private String stuBirthday;
        /**学生电话*/
        private String stuPhone;
        /**学生邮箱*/
        private String stuMail;
        /**学生地址*/
        private String stuAddress;
        /**优秀毕业生标志位，0是无，1是候选人，2是选上了，3是落选*/
        private String stuRemarks;
        
        private Integer academyId;
        
        public String getStuPassword() {
            return this.stuPassword;
        }
        
        public void setStuPassword(String stuPassword) {
            this.stuPassword = stuPassword;
        }
        
        public String getStuName() {
            return this.stuName;
        }
        
        public void setStuName(String stuName) {
            this.stuName = stuName;
        }
        
        public String getStuMajor() {
            return this.stuMajor;
        }
        
        public void setStuMajor(String stuMajor) {
            this.stuMajor = stuMajor;
        }
        
        public String getStuClass() {
            return this.stuClass;
        }
        
        public void setStuClass(String stuClass) {
            this.stuClass = stuClass;
        }
        
        public String getStuSex() {
            return this.stuSex;
        }
        
        public void setStuSex(String stuSex) {
            this.stuSex = stuSex;
        }
        
        public Integer getStuAge() {
            return this.stuAge;
        }
        
        public void setStuAge(Integer stuAge) {
            this.stuAge = stuAge;
        }
        
        public String getStuBirthday() {
            return this.stuBirthday;
        }
        
        public void setStuBirthday(String stuBirthday) {
            this.stuBirthday = stuBirthday;
        }
        
        public String getStuPhone() {
            return this.stuPhone;
        }
        
        public void setStuPhone(String stuPhone) {
            this.stuPhone = stuPhone;
        }
        
        public String getStuMail() {
            return this.stuMail;
        }
        
        public void setStuMail(String stuMail) {
            this.stuMail = stuMail;
        }
        
        public String getStuAddress() {
            return this.stuAddress;
        }
        
        public void setStuAddress(String stuAddress) {
            this.stuAddress = stuAddress;
        }
        
        public String getStuRemarks() {
            return this.stuRemarks;
        }
        
        public void setStuRemarks(String stuRemarks) {
            this.stuRemarks = stuRemarks;
        }
        
        public Integer getAcademyId() {
            return this.academyId;
        }
        
        public void setAcademyId(Integer academyId) {
            this.academyId = academyId;
        }
        
        public Student toModel() {
            Student model = new Student();
			BeanUtil.convert(this, model);
			return model;
        }
    
}