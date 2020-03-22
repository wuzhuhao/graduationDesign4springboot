package com.graduationaldesign.graduation.pojo.helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: wuzhuhao
 * @Date: 2020/3/21 0021 23:35
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Column {
    String columnName();//表格字段名

//    String type();//字段类型
//
//    int length();//字段长度

    //字段预备前端约定名字
    String viewName() default "";
}