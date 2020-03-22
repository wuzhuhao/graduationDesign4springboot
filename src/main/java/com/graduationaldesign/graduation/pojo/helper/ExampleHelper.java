package com.graduationaldesign.graduation.pojo.helper;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.poi.ss.formula.functions.T;

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

    /**
     * 利用反射进行主表条件添加
     *
     * @param pojo
     * @param criteria
     * @param params
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
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
            if (isStringType(type, value)) {
                Method method = criteria.getClass().getMethod("and" + name + "Like", String.class);
                method.invoke(criteria, getValue(field, value));
            } else if (isIntOrLong(type, value)) {
                Method method = criteria.getClass()
                        .getMethod("and" + name + "EqualTo", Integer.class);
                method.invoke(criteria, Convert.toInt(value, 0));
            } else if (isDate(type, value)) {
                Method method = criteria.getClass()
                        .getMethod("and" + name + "EqualTo", Date.class);
                method.invoke(criteria, DateUtil.parse(value));
            }
        }
    }

    /**
     * 利用反射进行join表的条件添加
     *
     * @param pojo
     * @param criteria
     * @param params
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void addJoinCondition(Class pojo, Object criteria, Map<String, Object> params)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] fieldList = pojo.getDeclaredFields();
        String tableName = getTable(pojo);
        for (Field field : fieldList) {
            String columnName = getColumnName(field);
            //获取属性的名字
            String name = getViewName(field);
            //获取属性的类型
            String type = field.getGenericType().toString();
            String value = (String) params.get(name);
            //这里是String类型，其他以此类推
            //如果type是类类型，则前面包含"class "，后面跟类名
            if (isStringType(type, value)) {
                Method method = criteria.getClass().getMethod("andJoinEqualLike", String.class, String.class);
                method.invoke(criteria, getValue(field, value), tableName + "." + columnName);
            } else if (isIntOrLong(type, value)) {
                Method method = criteria.getClass()
                        .getMethod("andJoinEqualTo", Object.class, String.class);
                method.invoke(criteria, Convert.toLong(value, 0L), tableName + "." + columnName);
            } else if (isDate(type, value)) {
                Method method = criteria.getClass()
                        .getMethod("andJoinEqualTo", Object.class, String.class);
                method.invoke(criteria, DateUtil.parse(value), tableName + "." + columnName);
            }
        }
    }

    /**
     * 获取属性是否是模糊查询
     *
     * @param field
     * @param value
     * @return
     */
    public static String getValue(Field field, String value) {
        if (field.isAnnotationPresent(MyPrimaryKey.class)) {
            return value;
        } else {
            return "%" + value + "%";
        }
    }

    /**
     * 获取join表的字段
     *
     * @param field
     * @return
     */
    public static String getColumnName(Field field) {
        Column column = field.getAnnotation(Column.class);
        String columnName = "";
        if (column != null) {
            columnName = column.columnName();
        }
        return columnName;
    }

    /**
     * 获取join表的表名
     *
     * @param bean
     * @return
     */
    public static String getTable(Class<T> bean) {
        Table table = bean.getAnnotation(Table.class);
        return table.value();
    }

    /**
     * 获取与前端数据的名字
     *
     * @param field
     * @return
     */
    public static String getViewName(Field field) {
        //获取属性的名字
        String name = field.getName();
        if (field.isAnnotationPresent(MyPrimaryKey.class)) {
            name = field.getAnnotation(Column.class).viewName();
        }
        return name;
    }

    /**
     * 判断是否字符类型
     *
     * @param type
     * @param value
     * @return
     */
    public static boolean isStringType(String type, String value) {
        return type.equals("class java.lang.String") && StrUtil.isNotBlank(value);
    }

    /**
     * 判断是否int或者long类型
     *
     * @param type
     * @param value
     * @return
     */
    public static boolean isIntOrLong(String type, String value) {
        return (type.equals("class java.lang.Integer") || type.equals("class java.lang.Long")) && StrUtil.isNotBlank(value);
    }

    /**
     * 判断是否date类型
     *
     * @param type
     * @param value
     * @return
     */
    public static boolean isDate(String type, String value) {
        return type.equals("class java.util.Date") && StrUtil.isNotEmpty(value);
    }
}
