package com.graduationaldesign.graduation.aop;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 一周七天的枚举类
 *
 * @Author: wuzhuhao
 * @Date: 2020/4/5 0005 17:04
 */
public enum Day {
    /**
     * 一周七天的枚举数据
     */
    Monday(1, "monday"),
    Tuesday(2, "tuesday"),
    Wednesday(3, "wednesday"),
    Thursday(4, "thursday"),
    Friday(5, "friday"),
    Saturday(6, "saturday"),
    Sunday(7, "sunday");
    private int key;
    private String value;

    Day(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static int getKey(int key) {
        Day[] lstDay = values();
        for (Day day : lstDay) {
            if (day.key() == key) {
                return day.key();
            }
        }
        return 0;
    }

    public static List<String> getAllValues() {
        Day[] lstDay = values();
        return Arrays.asList(lstDay).stream().map(e -> e.value).collect(Collectors.toList());
    }

    public static List<Integer> getAllKeys() {
        Day[] lstDay = values();
        return Arrays.asList(lstDay).stream().map(e -> e.key()).collect(Collectors.toList());
    }

    public static String getValue(Date date) throws Exception {
        int key = dayForWeek(date);
        Day[] lstDay = values();
        for (Day day : lstDay) {
            if (day.key() == key) {
                return day.value();
            }
        }
        return null;
    }

    public int key() {
        return key;
    }

    public String value() {
        return value;
    }

    /**
     * 判断当前日期是星期几
     *
     * @param time 修要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    public static int dayForWeek(Date time) throws Exception {
//        DateUtil.formatDateTime(time);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }
}
