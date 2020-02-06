package com.graduationaldesign.graduation.pojo;

import lombok.Data;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/19 22:52
 */
@Data
public class UserModel {

    private String id;

    private String password;
    private String name;

    private String sex;

    private Integer age;

    private String birthday;

    private String phone;

    private String mail;

    private String address;

    private String remarks;

    private String class_;

    private String major;

    private Integer academyId;

    public UserModel() {
    }

    public UserModel(String id, String password, String name, String sex, Integer age,
            String birthday, String phone, String mail, String address, String remarks,
            String class_, String major, Integer academyId) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.remarks = remarks;
        this.class_ = class_;
        this.major = major;
        this.academyId = academyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", address='" + address + '\'' +
                ", remarks='" + remarks + '\'' +
                ", class_='" + class_ + '\'' +
                ", major='" + major + '\'' +
                ", academyId=" + academyId +
                '}';
    }
}
