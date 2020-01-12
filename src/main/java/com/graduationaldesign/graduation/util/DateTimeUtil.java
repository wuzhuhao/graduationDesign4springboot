package com.graduationaldesign.graduation.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间转换工具，注意该类不是线程安全的
 * @author wuzhuhao
 * 
 */
public final class DateTimeUtil {
    public static final String DATE_FORMAT = "yyyyMMdd";
    public static final String DATE_FORMAT_1 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_2 = "yyyyMM";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_1 = "yyyyMMddHHmmss";
    public static final String TIME_ONLY_FORMAT = "HH:mm:ss";
    public static final String YEAR_ONLY_FORMAT = "yyyy";
    public static final SimpleDateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public DateTimeUtil() {

    }

    /**
     * 获取系统当前日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取当天的零点时间
     *
     * @author wanyang3
     */
    public static Date getCurrentZeroDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 返回日期格式(yyyy-MM-dd HH:mm:ss)
     *
     * @param date 日志
     * @return
     */
    public static String toDateTimeStr(Date date) {
        if (date == null) {
            return "";
        }
        return DateTimeUtil.toDateStr(date, DATE_TIME_FORMAT);
    }

    /**
     * 返回日期格式(yyyyMMddHHmmss)
     *
     * @param date 日期
     * @return
     */
    public static String toDateTimeStr2(Date date) {
        if (date == null) {
            return "";
        }
        return DateTimeUtil.toDateStr(date, DATE_TIME_FORMAT_1);
    }

    /**
     * 返回日期格式(yyyy-MM-dd)
     *
     * @param date 日期
     * @return
     */
    public static String toDateStr(Date date) {
        if (date == null) {
            return "";
        }
        return DateTimeUtil.toDateStr(date, DATE_FORMAT_1);
    }

    /**
     * 返回时间格式(HH:mm:ss)
     *
     * @param date 日期
     * @return
     */
    public static String toTimeStr(Date date) {
        if (date == null) {
            return "";
        }
        return DateTimeUtil.toDateStr(date, TIME_ONLY_FORMAT);
    }

    /**
     * 返回日期格式(yyyyMMdd)
     *
     * @param date 日期
     * @return
     */
    public static String toDateStr2(Date date) {
        if (date == null) {
            return "";
        }
        return DateTimeUtil.toDateStr(date, DATE_FORMAT);
    }

    /**
     * 返回日期格式(yyyyMM)
     *
     * @param date 日期
     * @return
     */
    public static String toDateStr3(Date date) {
        if (date == null) {
            return "";
        }
        return DateTimeUtil.toDateStr(date, DATE_FORMAT_2);
    }

    /**
     * <p>
     * 得到xxxx年xx月xx日 日期格式。
     * </p>
     *
     * @param date 日期
     * @return
     */
    public static String toChinaDateStr(Date date) {
        if (date == null) {
            return "";
        }
        // 得到yyyy-mm-dd格式日期格式
        String dateStr = toDateStr(date);
        StringBuffer sb = new StringBuffer();
        if (dateStr != null && dateStr.length() > 0) {
            String[] newStr = dateStr.split("-");
            // 得到月
            int month = Integer.valueOf(newStr[1]);
            // 得到日
            int day = Integer.valueOf(newStr[2]);
            sb.append(newStr[0]).append("年");
            sb.append(month).append("月").append(day).append("日");
        }
        return sb.toString();
    }

    /**
     * <p>
     * 获取当前系统时间的小时数
     * </p>
     *
     * @return
     */
    public static int getCurrentHour() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * <p>
     * 获取当前系统时间的分钟数
     * </p>
     *
     * @return
     */
    public static int getCurrentMinutes() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * <p>
     * 获取本月第一天日期（格式如YYYYMMDD）,如果当前日为当月1日,则返回上月第一日
     * </p>
     *
     * @return
     */
    public static String getMonthFirstDay() {
        Calendar calendar = new GregorianCalendar();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = 0;
        if (day == 1) {
            calendar.add(Calendar.MONTH, -1);
        }
        month = calendar.get(Calendar.MONTH);
        if (month < 10) {
            return "" + calendar.get(Calendar.YEAR) + "0" + (month + 1) + "01";
        } else {
            return "" + calendar.get(Calendar.YEAR) + month + "01";
        }
    }

    /**
     * 取得一个月的第一天
     *
     * @return
     * @author wanyang3
     * @date 2013-3-20
     */
    public static Date getFristDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }

    /**
     * 根据传入的Date取得某个月的第一天
     *
     * @param date
     * @return
     * @author wanyang3
     * @date 2014年9月29日
     */
    public static Date getFristDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }

    /**
     * 取得一个月的最后一天
     *
     * @return
     * @author wanyang3
     * @date 2013-3-20
     */
    public static Date getLastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前时间前几天或后几天的日期
     *
     * @param days 天数
     * @return
     * @author wanyang3
     * @date 2013-3-20
     */
    public static Date getAddDays(int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 获取某个月后的日期格式（yyyyMMdd）
     *
     * @param monthNum 月数
     * @return
     * @author wanyang3
     * @date 2013-3-20
     */
    public static String getAfterMonth(int monthNum) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH, monthNum);
        return DateTimeUtil.toDateStr(calendar.getTime(), DATE_FORMAT);
    }

    /**
     * <p>
     * 返回日期（格式yyyyMMdd）
     * </p>
     *
     * @param timeMillis 时间
     * @return
     */
    public static String getFormatDate(long timeMillis) {
        return DateTimeUtil.toDateStr(new Date(timeMillis), DATE_TIME_FORMAT_1);
    }

    public static long getCurrentYear() {
        return Long.parseLong(DateTimeUtil.toDateStr(new Date(), YEAR_ONLY_FORMAT));
    }

    /**
     * 判断一个日期字符串是否合法
     *
     * @param date   日期
     * @param format 格式
     * @return
     * @author wanyang3
     */
    public static boolean isDateStringCorrect(String date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);

        try {
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * <p>
     * 将字符串类型的日期格式 转换为 符合要求的日期格式
     * </P>
     *
     * @param date   日期
     * @param format 格式
     * @return
     */
    public static String getStrDate4String(String date, String format) {
        if (date == null || date.trim().equals("")) {
            return "";
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            try {
                Date d = df.parse(date);
                return df.format(d);
            } catch (ParseException e) {
                return "";
            }
        }
    }

    /**
     * <p>
     * 将Date类型的日期格式 转换为 符合要求的 String日期格式
     * </P>
     *
     * @param date   日期
     * @param format 格式
     * @return
     */
    public static String toDateStr(Date date, String format) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        }
    }

    /**
     * <p>
     * 将字符串类型的日期格式 转换为 符合要求的 Date类型的日期格式
     * </P>
     *
     * @param date   日期
     * @param format 格式
     * @return
     */
    public static Date strToDate(String date, String format) {
        if (date == null || date.trim().equals("")) {
            return null;
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            try {
                return df.parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
    }

    /**
     * <p>
     * 得到起始日期和结束日期之间的天数
     * </P>
     *
     * @param beginStr 起始日期
     * @param endStr   结束日期
     * @param format   根据 日期参数的格式，传对应的SimpleDateFormat格式
     * @return 天数
     */
    public static int getDaysInterval(String beginStr, String endStr, SimpleDateFormat format) {

        try {
            Date beginDate = format.parse(beginStr);
            Date endDate = format.parse(endStr);
            long millisecond = endDate.getTime() - beginDate.getTime(); // 日期相减得到日期差X(单位:毫秒)
            return (int) (millisecond / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 取得当前的年
     *
     * @return
     * @author wanyang3
     * @date 2012-3-30
     */
    public static String getYear() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return Integer.toString(c.get(Calendar.YEAR));
    }

    /**
     * 取得当前的月
     *
     * @return
     * @author wanyang3
     * @date 2012-3-30
     */
    public static String getMonth() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return Integer.toString(c.get(Calendar.MONTH) + 1);
    }

    /**
     * 取得当前的日
     *
     * @return
     * @author wanyang3
     * @date 2012-3-30
     */
    public static String getDay() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return Integer.toString(c.get(Calendar.DATE));
    }

    /**
     * 将日期格式化为yyyyMMddTHHmmssZ
     *
     * @param date yyyy-MM-dd HH:mm:ss
     * @return String
     * @author wanyang3
     */
    public static String str2Str(String date) {
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String d = date.substring(8, 10);
        String h = date.substring(11, 13);
        String m = date.substring(14, 16);
        String s = date.substring(17, 19);
        return year + month + d + "T" + h + m + s + "Z";
    }

    /**
     * 取当天零点零分零秒
     */
    public static String getTodayStart() {
        Calendar calendar = Calendar.getInstance();
        // 如果没有这种设定的话回去系统的当期的时间
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = new Date(calendar.getTimeInMillis());
        return longDateFormat.format(date);
    }

    /**
     * 取当天23点59分59秒
     */
    public static String getTodayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date date = new Date(calendar.getTimeInMillis());
        return longDateFormat.format(date);
    }

    /**
     * 取特定日期的零点零分零秒
     */
    public static String getDateStart(String strDate) {
        if (null == strDate || "".equals(strDate.trim())) {
            return "";
        }
        Date date = null;
        try {
            date = shortDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return longDateFormat.format(date);
    }

    /**
     * 取特定日期的23点59分59秒
     */
    public static String getDateEnd(String strDate) {
        if (null == strDate || "".equals(strDate.trim())) {
            return "";
        }
        Date date = null;
        try {
            date = shortDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 这样能够取到59分59秒
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);

        return longDateFormat.format(calendar.getTime());
    }

    /**
     * 根据传入的Date对象获取下月的第一天
     *
     * @param date
     * @return
     * @author wanyang3
     * @date 2014年9月29日
     */
    public static Date getNextMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DAY_OF_YEAR, lastDay);
        Date firstDate = calendar.getTime();
        return firstDate;
    }

    public static boolean timePeriodCoincide(Date aStartDate, Date aEndDate, Date bStartDate, Date bEndDate) {
        return aEndDate.after(bStartDate) && bEndDate.after(aStartDate);
    }

}
