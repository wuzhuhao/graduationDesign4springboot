package com.graduationaldesign.graduation.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: wuzhuhao
 * @Date: 2020/4/2 0002 22:05
 */
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Api {
    //字段预备前端约定名字
    String Pojo() default "";

    String description() default "";
}
