package com.graduationaldesign.graduation.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graduationaldesign.graduation.pojo.helper.Column;
import com.graduationaldesign.graduation.pojo.helper.MyPrimaryKey;
import com.graduationaldesign.graduation.pojo.helper.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(value = {"handler"})
@Table(value = "t_student")
public class Student implements Serializable, User {

    /**
     * 学生登陆账号
     * 表字段 : t_student.stu_id
     */
    @Excel(name = "学号*", orderNum = "0")
    @MyPrimaryKey
    @Column(columnName = "stu_id")
    private String stuId;

    /**
     * 学生登陆密码
     * 表字段 : t_student.stu_password
     */
    @Excel(name = "密码", orderNum = "0")
    @Column(columnName = "stu_password")
    private String stuPassword;

    /**
     * 学生名称
     * 表字段 : t_student.stu_name
     */
    @Excel(name = "姓名", orderNum = "0")
    @Column(columnName = "stu_name")
    private String stuName;

    /**
     * 学生专业
     * 表字段 : t_student.stu_major
     */
    @Excel(name = "专业", orderNum = "0")
    @Column(columnName = "stu_major")
    private String stuMajor;

    /**
     * 学生班级
     * 表字段 : t_student.stu_class
     */
    @Excel(name = "班级", orderNum = "0")
    @Column(columnName = "stu_class")
    private String stuClass;

    /**
     * 学生性别
     * 表字段 : t_student.stu_sex
     */
    @Excel(name = "性别", orderNum = "0")
    @Column(columnName = "stu_sex")
    private String stuSex;

    /**
     * 学生年龄
     * 表字段 : t_student.stu_age
     */
    @Excel(name = "年龄", orderNum = "0")
    @Column(columnName = "stu_age")
    private Integer stuAge;

    /**
     * 学生生日
     * 表字段 : t_student.stu_birthday
     */
    @Excel(name = "出生日期", orderNum = "2")
    @Column(columnName = "stu_birthday")
    private String stuBirthday;

    /**
     * 学生电话
     * 表字段 : t_student.stu_phone
     */
    @Excel(name = "电话", orderNum = "0")
    @Column(columnName = "stu_phone")
    private String stuPhone;

    /**
     * 学生邮箱
     * 表字段 : t_student.stu_mail
     */
    @Excel(name = "邮箱", orderNum = "0")
    @Column(columnName = "stu_mail")
    private String stuMail;

    /**
     * 学生地址
     * 表字段 : t_student.stu_address
     */
    @Excel(name = "地址", orderNum = "0")
    @Column(columnName = "stu_address")
    private String stuAddress;

    /**
     * 优秀毕业生标志位，0是无，1是候选人，2是选上了，3是落选
     * 表字段 : t_student.stu_remarks
     */
    @Excel(name = "优秀毕业生", orderNum = "0")
    @Column(columnName = "stu_remarks")
    private String stuRemarks;

    /**
     * 表字段 : t_student.academy_id
     */
    @Excel(name = "学院代码*", orderNum = "0")
    @Column(columnName = "academy_id", joinPojo = "Academy")
    private Integer academyId;

    private Academy academy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_student
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 学生登陆账号 字段:t_student.stu_id
     *
     * @return t_student.stu_id, 学生登陆账号
     */
    public String getStuId() {
        return stuId;
    }

    /**
     * 设置 学生登陆账号 字段:t_student.stu_id
     *
     * @param stuId the value for t_student.stu_id, 学生登陆账号
     */
    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    /**
     * 获取 学生登陆密码 字段:t_student.stu_password
     *
     * @return t_student.stu_password, 学生登陆密码
     */
    public String getStuPassword() {
        return stuPassword;
    }

    /**
     * 设置 学生登陆密码 字段:t_student.stu_password
     *
     * @param stuPassword the value for t_student.stu_password, 学生登陆密码
     */
    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword == null ? null : stuPassword.trim();
    }

    /**
     * 获取 学生名称 字段:t_student.stu_name
     *
     * @return t_student.stu_name, 学生名称
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * 设置 学生名称 字段:t_student.stu_name
     *
     * @param stuName the value for t_student.stu_name, 学生名称
     */
    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    /**
     * 获取 学生专业 字段:t_student.stu_major
     *
     * @return t_student.stu_major, 学生专业
     */
    public String getStuMajor() {
        return stuMajor;
    }

    /**
     * 设置 学生专业 字段:t_student.stu_major
     *
     * @param stuMajor the value for t_student.stu_major, 学生专业
     */
    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor == null ? null : stuMajor.trim();
    }

    /**
     * 获取 学生班级 字段:t_student.stu_class
     *
     * @return t_student.stu_class, 学生班级
     */
    public String getStuClass() {
        return stuClass;
    }

    /**
     * 设置 学生班级 字段:t_student.stu_class
     *
     * @param stuClass the value for t_student.stu_class, 学生班级
     */
    public void setStuClass(String stuClass) {
        this.stuClass = stuClass == null ? null : stuClass.trim();
    }

    /**
     * 获取 学生年龄 字段:t_student.stu_sex
     *
     * @return t_student.stu_sex, 学生年龄
     */
    public String getStuSex() {
        return stuSex;
    }

    /**
     * 设置 学生年龄 字段:t_student.stu_sex
     *
     * @param stuSex the value for t_student.stu_sex, 学生年龄
     */
    public void setStuSex(String stuSex) {
        this.stuSex = stuSex == null ? null : stuSex.trim();
    }

    /**
     * 获取 学生年龄 字段:t_student.stu_age
     *
     * @return t_student.stu_age, 学生年龄
     */
    public Integer getStuAge() {
        return stuAge;
    }

    /**
     * 设置 学生年龄 字段:t_student.stu_age
     *
     * @param stuAge the value for t_student.stu_age, 学生年龄
     */
    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    /**
     * 获取 学生生日 字段:t_student.stu_birthday
     *
     * @return t_student.stu_birthday, 学生生日
     */
    public String getStuBirthday() {
        return stuBirthday;
    }

    /**
     * 设置 学生生日 字段:t_student.stu_birthday
     *
     * @param stuBirthday the value for t_student.stu_birthday, 学生生日
     */
    public void setStuBirthday(String stuBirthday) {
        try {
            DateTime parse = DateUtil.parse(stuBirthday);
            stuBirthday = DateUtil.formatDateTime(parse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.stuBirthday = stuBirthday == null ? null : stuBirthday.trim();
    }

    /**
     * 获取 学生电话 字段:t_student.stu_phone
     *
     * @return t_student.stu_phone, 学生电话
     */
    public String getStuPhone() {
        return stuPhone;
    }

    /**
     * 设置 学生电话 字段:t_student.stu_phone
     *
     * @param stuPhone the value for t_student.stu_phone, 学生电话
     */
    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    /**
     * 获取 学生邮箱 字段:t_student.stu_mail
     *
     * @return t_student.stu_mail, 学生邮箱
     */
    public String getStuMail() {
        return stuMail;
    }

    /**
     * 设置 学生邮箱 字段:t_student.stu_mail
     *
     * @param stuMail the value for t_student.stu_mail, 学生邮箱
     */
    public void setStuMail(String stuMail) {
        this.stuMail = stuMail == null ? null : stuMail.trim();
    }

    /**
     * 获取 学生地址 字段:t_student.stu_address
     *
     * @return t_student.stu_address, 学生地址
     */
    public String getStuAddress() {
        return stuAddress;
    }

    /**
     * 设置 学生地址 字段:t_student.stu_address
     *
     * @param stuAddress the value for t_student.stu_address, 学生地址
     */
    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress == null ? null : stuAddress.trim();
    }

    /**
     * 获取 优秀毕业生标志位，0是无，1是候选人，2是选上了，3是落选 字段:t_student.stu_remarks
     *
     * @return t_student.stu_remarks, 优秀毕业生标志位，0是无，1是候选人，2是选上了，3是落选
     */
    public String getStuRemarks() {
        return stuRemarks;
    }

    /**
     * 设置 优秀毕业生标志位，0是无，1是候选人，2是选上了，3是落选 字段:t_student.stu_remarks
     *
     * @param stuRemarks the value for t_student.stu_remarks, 优秀毕业生标志位，0是无，1是候选人，2是选上了，3是落选
     */
    public void setStuRemarks(String stuRemarks) {
        this.stuRemarks = stuRemarks == null ? null : stuRemarks.trim();
    }

    /**
     * 获取  字段:t_student.academy_id
     *
     * @return t_student.academy_id,
     */
    public Integer getAcademyId() {
        return academyId;
    }

    /**
     * 设置  字段:t_student.academy_id
     *
     * @param academyId the value for t_student.academy_id,
     */
    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    @JsonIgnore
    public Academy getAcademy() {
        return academy;
    }

    @JsonGetter(value = "academy")
    public Academy getAcademyDetail() {//自定的方法
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    @Override
    public String findUserName() {
        return stuId;
    }

    @Override
    public String findUserType() {
        return "学生";
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuMajor='" + stuMajor + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuAge=" + stuAge +
                ", stuBirthday='" + stuBirthday + '\'' +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuMail='" + stuMail + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                ", stuRemarks='" + stuRemarks + '\'' +
                ", academyId=" + academyId +
                ", academy=" + academy +
                '}';
    }

    public Student(String stuId, String stuPassword) {
        this.stuId = stuId;
        this.stuPassword = stuPassword;
    }

    public Student(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public Student() {
    }

    public Student(String stuId, String stuName, String stuMajor, String stuClass,
                   String stuSex, Integer stuAge, String stuBirthday, String stuPhone,
                   String stuMail, String stuAddress, String stuRemarks) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuMajor = stuMajor;
        this.stuClass = stuClass;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuBirthday = stuBirthday;
        this.stuPhone = stuPhone;
        this.stuMail = stuMail;
        this.stuAddress = stuAddress;
        this.stuRemarks = stuRemarks;
    }

    public void setModel(UserModel userModel) {
        this.setStuAddress(userModel.getAddress());
        this.setStuAge(userModel.getAge());
        this.setStuBirthday(userModel.getBirthday());
        this.setStuClass(userModel.getClass_());
        this.setStuMail(userModel.getMail());
        this.setStuMajor(userModel.getMajor());
        this.setStuName(userModel.getName());
        this.setStuPhone(userModel.getPhone());
        this.setStuRemarks(userModel.getRemarks());
        this.setStuSex(userModel.getSex());
    }
}