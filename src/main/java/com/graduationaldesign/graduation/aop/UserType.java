package com.graduationaldesign.graduation.aop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wuzhuhao
 * @Date: 2020/4/5 0005 17:40
 */
public enum UserType {

    /**
     * 学生类型转换
     */
    Student("学生", "student"),
    Teacher("导师", "teacher"),
    Admin("管理员", "admin");
    private String key;
    private String value;

    UserType(String key, String value) {
        this.key = key;
        this.value = value;
    }


    public static String getKey(String key) {
        UserType[] lstUserType = values();
        for (UserType userType : lstUserType) {
            if (userType.key().equals(key)) {
                return userType.key();
            }
        }
        return null;
    }

    public static String getValue(String key) {
        UserType[] lstUserType = values();
        List<UserType> lstUserType1 = Arrays.asList(lstUserType).stream().collect(Collectors.toList());
        lstUserType1 = lstUserType1.stream().filter(e -> e.key().equals(key) || key.indexOf(e.key()) != -1).collect(Collectors.toList());
        if (lstUserType1.size() == 1) {
            for (UserType userType : lstUserType1) {
                if (key.indexOf(userType.key()) != -1) {
                    return userType.value();
                }
            }
        } else if (lstUserType1.size() > 1) {
            for (UserType userType : lstUserType1) {
                if (userType.key().equals(key)) {
                    return userType.value();
                }
            }
        }
        return null;
    }

    public String key() {
        return key;
    }

    public String value() {
        return value;
    }

    public static List<String> getAllValues() {
        UserType[] lstUserType = values();
        return Arrays.asList(lstUserType).stream().map(e -> e.value).collect(Collectors.toList());
    }

    public static List<String> getAllKeys() {
        UserType[] lstUserType = values();
        return Arrays.asList(lstUserType).stream().map(e -> e.key()).collect(Collectors.toList());
    }
}
