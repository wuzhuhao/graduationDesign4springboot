package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.io.Serializable;


public class TTeacherDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**教师密码*/
        private String teaPassword;
        /**教师名称*/
        private String teaName;
        /**教师性别*/
        private String teaSex;
        /**教师年龄*/
        private Integer teaAge;
        /**教师生日*/
        private String teaBirthday;
        /**教师电话*/
        private String teaPhone;
        /**教师邮箱*/
        private String teaMail;
        /**教师地址*/
        private String teaAddress;
        /**备注*/
        private String teaRemarks;
        /**学院id*/
        private Integer academyId;
        
        public String getTeaPassword() {
            return this.teaPassword;
        }
        
        public void setTeaPassword(String teaPassword) {
            this.teaPassword = teaPassword;
        }
        
        public String getTeaName() {
            return this.teaName;
        }
        
        public void setTeaName(String teaName) {
            this.teaName = teaName;
        }
        
        public String getTeaSex() {
            return this.teaSex;
        }
        
        public void setTeaSex(String teaSex) {
            this.teaSex = teaSex;
        }
        
        public Integer getTeaAge() {
            return this.teaAge;
        }
        
        public void setTeaAge(Integer teaAge) {
            this.teaAge = teaAge;
        }
        
        public String getTeaBirthday() {
            return this.teaBirthday;
        }
        
        public void setTeaBirthday(String teaBirthday) {
            this.teaBirthday = teaBirthday;
        }
        
        public String getTeaPhone() {
            return this.teaPhone;
        }
        
        public void setTeaPhone(String teaPhone) {
            this.teaPhone = teaPhone;
        }
        
        public String getTeaMail() {
            return this.teaMail;
        }
        
        public void setTeaMail(String teaMail) {
            this.teaMail = teaMail;
        }
        
        public String getTeaAddress() {
            return this.teaAddress;
        }
        
        public void setTeaAddress(String teaAddress) {
            this.teaAddress = teaAddress;
        }
        
        public String getTeaRemarks() {
            return this.teaRemarks;
        }
        
        public void setTeaRemarks(String teaRemarks) {
            this.teaRemarks = teaRemarks;
        }
        
        public Integer getAcademyId() {
            return this.academyId;
        }
        
        public void setAcademyId(Integer academyId) {
            this.academyId = academyId;
        }
        
        public Teacher toModel() {
            Teacher model = new Teacher();
			BeanUtil.convert(this, model);
			return model;
        }
    
}