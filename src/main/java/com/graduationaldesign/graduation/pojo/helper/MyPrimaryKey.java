package com.graduationaldesign.graduation.pojo.helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther:：9527
 * @Description: 创建一个注解
 * @program: jstl2
 * @create: 2019-10-04 20:30  这两个元注解必须用大写的，因为是静态常量
 */
@Target({ElementType.METHOD, ElementType.FIELD,})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyPrimaryKey {

    //这是一个方法，当注解里面方法名只有一个的时候，那么使用注解的时候是可以不用写 方法名=“xx”的
    //这里方法的作用主要是搬运信息
    //此处方法的默认修饰符是public abstract
    //这里的方法的参数可以通过default设定默认
//    String[] value() default {"李白", "杜甫"};
}
