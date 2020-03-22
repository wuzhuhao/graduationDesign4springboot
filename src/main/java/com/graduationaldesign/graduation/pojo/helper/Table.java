package com.graduationaldesign.graduation.pojo.helper;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Author: wuzhuhao
 * @Date: 2020/3/21 0021 23:34
 */
@Target(value= {ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Table {
    String value();//只有一个参数建议起名value
}