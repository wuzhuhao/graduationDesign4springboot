package com.graduationaldesign.graduation.pojo.helper;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.graduationaldesign.graduation.pojo.Example;
import com.graduationaldesign.graduation.util.DataConvertUtil;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

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
            } else if (type.equals("class java.lang.Integer") && StrUtil.isNotBlank(value)) {
                Method method = criteria.getClass()
                        .getMethod("and" + name + "EqualTo", Integer.class);
                method.invoke(criteria, Convert.toInt(value, 0));
            } else if (type.equals("class java.lang.Long") && StrUtil.isNotBlank(value)) {
                Method method = criteria.getClass()
                        .getMethod("and" + name + "EqualTo", Long.class);
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

    //    public static List<String> getLstFieldName(Class pojo) {
//        Field[] fieldList = pojo.getDeclaredFields();
//        List<String> lstFieldName = new ArrayList<>();
//        for (Field field : fieldList) {
//            //获取属性的名字
//            String name = field.getName();
//            if (field.isAnnotationPresent(Dict.class)) {
//                lstFieldName.add(name);
//            }
//        }
//        return lstFieldName;
//    }
    public static Field getPrimaryKey(Class pojo) {
        Field[] fieldList = pojo.getDeclaredFields();
        for (Field field : fieldList) {
            if (field.isAnnotationPresent(MyPrimaryKey.class)) {
                return field;
            }
        }
        return null;
    }

    public static void searchJoin(Class pojo, Example example, Object criteria, Map<String, Object> params) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        example.setDistinct(true);
        searchJoin(pojo, example, criteria, params, null, true, false);
    }

    public static void searchJoin(Class pojo, Example example, Object criteria, Map<String, Object> params, List<String> lstJoin, boolean isForce, boolean isConversion) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> lstKey = params.keySet().stream().collect(Collectors.toList());
        //查找出所有外键
        List<Field> lstField = Arrays.asList(pojo.getDeclaredFields()).stream().filter(field -> (field.isAnnotationPresent(Column.class) && !field.getAnnotation(Column.class).joinPojo().equals(""))).collect(Collectors.toList());
        //查询出请求中的join
        if (lstJoin == null) {
            lstJoin = lstKey.stream().filter(e -> (e.contains("isJoin") && DataConvertUtil.strToBoolean(DataConvertUtil.objToStr(params.get(e))))).collect(Collectors.toList());
        }
        //join中的pojo
        List<String> lstJoinTable = lstJoin.stream().map(e -> e.substring("isJoin".length(), e.length())).collect(Collectors.toList());
        //请求中的table和实体类的table交集
        lstField = lstField.stream().filter(item -> lstJoinTable.contains(item.getAnnotation(Column.class).joinPojo())).collect(Collectors.toList());
        String tableName = getTable(pojo);
        List<String> lstJoinEdTable = lstField.stream().map(e -> e.getAnnotation(Column.class).joinPojo()).collect(Collectors.toList());
        List<String> lstJoin1 = lstJoin.stream().filter(e -> lstJoinEdTable.contains(e.substring("isJoin".length()))).collect(Collectors.toList());
        lstJoin.removeAll(lstJoin1);
        for (Field field : lstField) {
            Column column = field.getAnnotation(Column.class);
            Class obj = Class.forName("com.graduationaldesign.graduation.pojo." + column.joinPojo());
            String joinTableName = getTable(obj);
            Field joinTablefield = getPrimaryKey(obj);
            if (joinTablefield != null) {
                Method method = example.getClass()
                        .getMethod("getJoin");
                String joinSql = (method.invoke(example) == null) ? "" : (String) method.invoke(example);
                if (isConversion) {
                    joinSql += " left join " + tableName + " on " + tableName + "." + column.columnName() + " = " + joinTableName + "." + joinTablefield.getAnnotation(Column.class).columnName();
                } else {
                    joinSql += " left join " + joinTableName + " on " + tableName + "." + column.columnName() + " = " + joinTableName + "." + joinTablefield.getAnnotation(Column.class).columnName();
                }
                Method setJoin = example.getClass()
                        .getMethod("setJoin", String.class);
                setJoin.invoke(example, joinSql);
                //增加条件
                addJoinCondition(obj, criteria, params);
                searchJoin(obj, example, criteria, params, lstJoin, false, false);
            }
        }
        //进行强连
        if (lstJoin.size() != 0 && isForce) {
            for (String e : lstJoin) {
                Class obj = Class.forName("com.graduationaldesign.graduation.pojo." + e.substring("isJoin".length()));
                ArrayList<String> lstJoins = new ArrayList<>();
                lstJoins.add("isJoin" + pojo.getSimpleName());
                searchJoin(obj, example, criteria, params, lstJoins, false, true);
            }
        }
        //处理多个类lstField
    }
}
