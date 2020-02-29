package com.graduationaldesign.graduation.pojo.helper;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/2/29 11:22
 */
public class ExampleHelper {

    public static void addCondition(Class pojo, Object criteria, Map<String, Object> params)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] fieldList = pojo.getDeclaredFields();
        for (Field field : fieldList) {
            //获取属性的名字
            String name = field.getName();
            //将属性的首字符大写，方便构造方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            //获取属性的类型
            String type = field.getGenericType().toString();
            String value = (String) params.get(field.getName());
            //这里是String类型，其他以此类推
            //如果type是类类型，则前面包含"class "，后面跟类名
            if (type.equals("class java.lang.String") && StrUtil.isNotBlank(value)) {
                Method method = criteria.getClass().getMethod("and" + name + "Like", String.class);
                method.invoke(criteria, getValue(field, value));
            } else if (
                    (type.equals("class java.lang.Integer") || type.equals("class java.lang.Long"))
                            && StrUtil.isNotBlank(value)) {
                Method method = criteria.getClass()
                        .getMethod("and" + name + "EqualTo", Integer.class);
                method.invoke(criteria, Convert.toInt(value, 0));
            } else if (type.equals("class java.util.Date")
                    && StrUtil.isNotEmpty(value)) {
                Method method = criteria.getClass()
                        .getMethod("and" + name + "EqualTo", Date.class);
                method.invoke(criteria, DateUtil.parse(value));
            }
        }
    }

    public static String getValue(Field field, String value) {
        if (field.isAnnotationPresent(MyPrimaryKey.class)) {
            return value;
        } else {
            return "%" + value + "%";
        }
    }
}
