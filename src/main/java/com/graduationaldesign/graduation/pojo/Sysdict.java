package com.graduationaldesign.graduation.pojo;

import com.graduationaldesign.graduation.pojo.helper.Table;

import java.io.Serializable;
@Table(value = "sys_sysdict")
public class Sysdict implements Serializable {
    /**
     * 自增id
     * 表字段 : sys_sysdict.id
     */
    private Long id;

    /**
     * 父节点id
     * 表字段 : sys_sysdict.dict_parentId
     */
    private Long dictParentid;

    /**
     * 类型，model，item，dict
     * 表字段 : sys_sysdict.dict_type
     */
    private String dictType;

    /**
     * 系统里面的值
     * 表字段 : sys_sysdict.dict_value
     */
    private String dictValue;

    /**
     * 显示给用户的值
     * 表字段 : sys_sysdict.dict_text
     */
    private String dictText;

    /**
     * 描述
     * 表字段 : sys_sysdict.dict_description
     */
    private String dictDescription;

    /**
     * 
     * 表字段 : sys_sysdict.ext1
     */
    private String ext1;

    /**
     * 
     * 表字段 : sys_sysdict.ext2
     */
    private String ext2;

    /**
     * 
     * 表字段 : sys_sysdict.ext3
     */
    private String ext3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_sysdict
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 自增id 字段:sys_sysdict.id
     *
     * @return sys_sysdict.id, 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增id 字段:sys_sysdict.id
     *
     * @param id the value for sys_sysdict.id, 自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 父节点id 字段:sys_sysdict.dict_parentId
     *
     * @return sys_sysdict.dict_parentId, 父节点id
     */
    public Long getDictParentid() {
        return dictParentid;
    }

    /**
     * 设置 父节点id 字段:sys_sysdict.dict_parentId
     *
     * @param dictParentid the value for sys_sysdict.dict_parentId, 父节点id
     */
    public void setDictParentid(Long dictParentid) {
        this.dictParentid = dictParentid;
    }

    /**
     * 获取 类型，model，item，dict 字段:sys_sysdict.dict_type
     *
     * @return sys_sysdict.dict_type, 类型，model，item，dict
     */
    public String getDictType() {
        return dictType;
    }

    /**
     * 设置 类型，model，item，dict 字段:sys_sysdict.dict_type
     *
     * @param dictType the value for sys_sysdict.dict_type, 类型，model，item，dict
     */
    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    /**
     * 获取 系统里面的值 字段:sys_sysdict.dict_value
     *
     * @return sys_sysdict.dict_value, 系统里面的值
     */
    public String getDictValue() {
        return dictValue;
    }

    /**
     * 设置 系统里面的值 字段:sys_sysdict.dict_value
     *
     * @param dictValue the value for sys_sysdict.dict_value, 系统里面的值
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    /**
     * 获取 显示给用户的值 字段:sys_sysdict.dict_text
     *
     * @return sys_sysdict.dict_text, 显示给用户的值
     */
    public String getDictText() {
        return dictText;
    }

    /**
     * 设置 显示给用户的值 字段:sys_sysdict.dict_text
     *
     * @param dictText the value for sys_sysdict.dict_text, 显示给用户的值
     */
    public void setDictText(String dictText) {
        this.dictText = dictText == null ? null : dictText.trim();
    }

    /**
     * 获取 描述 字段:sys_sysdict.dict_description
     *
     * @return sys_sysdict.dict_description, 描述
     */
    public String getDictDescription() {
        return dictDescription;
    }

    /**
     * 设置 描述 字段:sys_sysdict.dict_description
     *
     * @param dictDescription the value for sys_sysdict.dict_description, 描述
     */
    public void setDictDescription(String dictDescription) {
        this.dictDescription = dictDescription == null ? null : dictDescription.trim();
    }

    /**
     * 获取  字段:sys_sysdict.ext1
     *
     * @return sys_sysdict.ext1, 
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置  字段:sys_sysdict.ext1
     *
     * @param ext1 the value for sys_sysdict.ext1, 
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * 获取  字段:sys_sysdict.ext2
     *
     * @return sys_sysdict.ext2, 
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 设置  字段:sys_sysdict.ext2
     *
     * @param ext2 the value for sys_sysdict.ext2, 
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * 获取  字段:sys_sysdict.ext3
     *
     * @return sys_sysdict.ext3, 
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * 设置  字段:sys_sysdict.ext3
     *
     * @param ext3 the value for sys_sysdict.ext3, 
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }
}