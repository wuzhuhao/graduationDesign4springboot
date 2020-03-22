package com.graduationaldesign.graduation.util;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataConvertUtil {
    public DataConvertUtil() {
    }

    public static String objToStr(Object value) {
        return value != null ? value.toString() : "";
    }

    public static String dateToStr(Date value, String format) {
        String dateString;
        if (value == null) {
            dateString = "";
        } else {
            SimpleDateFormat formatDate = new SimpleDateFormat(format, Locale.getDefault());
            dateString = formatDate.format(value);
        }

        return dateString;
    }

    public static String dateToStr(Date value) {
        return dateToStr(value, "yyyy-MM-dd");
    }

    public static String dateTimeToStr(Date value) {
        return dateToStr(value, "yyyy-MM-dd HH:mm:ss");
    }

    public static String dateToUTCStr(Date dateTime) {
        String format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = sdf.format(dateTime);
        return dateString;
    }

    public static String douToStr(Double value) {
        return value == null ? "" : BigDecimal.valueOf(value).toPlainString();
    }

    public static String integerToStr(Integer value) {
        return value == null ? "" : value.toString();
    }

    public static String longToStr(Long value) {
        return value == null ? "" : value.toString();
    }

    public static double objToDou(Object value) {
        double result = 0.0D;
        if (value != null) {
            String str = value.toString();

            try {
                result = Double.parseDouble(str);
            } catch (Exception var5) {
            }
        }

        return result;
    }

    public static Double objToDouNull(Object value) {
        Double result = null;
        if (value != null) {
            String str = value.toString();

            try {
                result = Double.parseDouble(str);
            } catch (Exception var4) {
            }
        }

        return result;
    }

    public static String objDouToStr(Object value) {
        return objDouToStr(value, (String) null);
    }

    public static String objDouToStr(Object value, String format) {
        String result = "";
        if (value != null) {
            Double dou = null;
            String str = value.toString();

            try {
                dou = Double.parseDouble(str);
            } catch (Exception var6) {
            }

            if (dou != null) {
                if (StringUtils.isEmpty(format)) {
                    result = dou.toString();
                } else {
                    DecimalFormat df = new DecimalFormat(format);
                    result = df.format(dou);
                }
            }
        }

        return result;
    }

    public static Long objToLong(Object value) {
        Long result = 0L;
        if (value != null) {
            String str = value.toString();

            try {
                result = Long.parseLong(str);
            } catch (Exception var4) {
            }
        }

        return result;
    }

    public static Long objToLongNull(Object value) {
        Long result = null;
        if (value != null) {
            String str = value.toString();

            try {
                result = Long.parseLong(str);
            } catch (Exception var4) {
            }
        }

        return result;
    }

    public static Integer objToInteger(Object value) {
        Integer result = 0;
        if (value != null) {
            String str = value.toString();

            try {
                result = Integer.parseInt(str);
            } catch (Exception var4) {
            }
        }

        return result;
    }

    public static Integer objToIntegerNull(Object value) {
        Integer result = null;
        if (value != null) {
            String str = value.toString();

            try {
                result = Integer.parseInt(str);
            } catch (Exception var4) {
            }
        }

        return result;
    }

    public static String objClobToStr(Object value) throws Exception {
        Clob clob = (Clob) value;
        String objv = "";
        BufferedReader cb = new BufferedReader(clob.getCharacterStream());

        for (String str = ""; (str = cb.readLine()) != null; objv = objv.concat(str)) {
        }

        return objv;
    }

    public static double strToDou(String value) {
        double result = 0.0D;

        try {
            result = Double.parseDouble(value);
        } catch (Exception var4) {
        }

        return result;
    }

    public static Double strToDouble(String value) {
        Double result = 0.0D;

        try {
            result = Double.parseDouble(value);
        } catch (Exception var3) {
        }

        return result;
    }

    public static Double strToDouNull(String value) {
        Double result = null;

        try {
            result = Double.parseDouble(value);
        } catch (Exception var3) {
        }

        return result;
    }

    public static Long strToLong(String value) {
        Long result = 0L;

        try {
            result = Long.parseLong(value);
        } catch (Exception var3) {
        }

        return result;
    }

    public static Long strToLongNull(String value) {
        Long result = null;

        try {
            result = Long.parseLong(value);
        } catch (Exception var3) {
        }

        return result;
    }

    public static int strToInt(String value) {
        int result = 0;

        try {
            result = Integer.parseInt(value);
        } catch (Exception var3) {
        }

        return result;
    }

    public static Integer strToInteger(String value) {
        int result = 0;

        try {
            if (value != null) {
                result = Integer.parseInt(value);
            }
        } catch (Exception var3) {
        }

        return result;
    }

    public static Integer strToIntegerNull(String value) {
        Integer result = null;

        try {
            result = Integer.parseInt(value);
        } catch (Exception var3) {
        }

        return result;
    }

    public static Date strToDate(String value) {
        return strToDate(value, "yyyy-MM-dd");
    }

    public static Date strToDateTime(String value) {
        return strToDate(value, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date strToDate(String value, String format) {
        if (value != null && value.trim().length() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());

            try {
                Date e = sdf.parse(value);
                return e;
            } catch (ParseException var4) {
            }
        }

        return null;
    }

    public static String strToStr(String value) {
        return value != null ? value : "";
    }

    public static String strToStrNull(String value) {
        return !StringUtils.isEmpty(value) ? value : null;
    }

    public static double douNullToDou(Double value) {
        double result = 0.0D;
        if (value == null) {
            return result;
        } else {
            result = value;
            return result;
        }
    }

    public static int intNullToInt(Integer value) {
        int result = 0;
        if (value == null) {
            return result;
        } else {
            result = value;
            return result;
        }
    }

    public static long longNullToLong(Long value) {
        long result = 0L;
        if (value == null) {
            return result;
        } else {
            result = value;
            return result;
        }
    }

    public static int LongToInt(Long value) {
        return value == null ? 0 : value.intValue();
    }

    public static List<Long> strsToLongList(String strs) {
        if (StringUtils.isEmpty(strs)) {
            return new ArrayList();
        } else {
            List<String> lstStrId = Arrays.asList(strs.contains(",") ? strs.split(",") : new String[]{strs});
            List<Long> lstId = new ArrayList();
            Iterator var3 = lstStrId.iterator();

            while (var3.hasNext()) {
                String strId = (String) var3.next();
                Long value = strToLong(strId);
                if (!lstId.contains(value)) {
                    lstId.add(value);
                }
            }

            return lstId;
        }
    }

    public static List<String> longToStrList(List<Long> longs) {
        List<String> lstStrId = new ArrayList();
        Iterator var2 = longs.iterator();

        while (var2.hasNext()) {
            Long value = (Long) var2.next();
            lstStrId.add(value.toString());
        }

        return lstStrId;
    }

    public static List<Double> strsToDouList(String strs) {
        if (StringUtils.isEmpty(strs)) {
            return new ArrayList();
        } else {
            List<String> lstStrId = Arrays.asList(strs.contains(",") ? strs.split(",") : new String[]{strs});
            List<Double> lstId = new ArrayList();
            Iterator var3 = lstStrId.iterator();

            while (var3.hasNext()) {
                String strId = (String) var3.next();
                Double value = strToDouble(strId);
                if (!lstId.contains(value)) {
                    lstId.add(value);
                }
            }

            return lstId;
        }
    }

    public static List<String> strsToStrList(String strs) {
        if (StringUtils.isEmpty(strs)) {
            return new ArrayList();
        } else {
            List<String> lstStrId = Arrays.asList(strs.contains(",") ? strs.split(",") : new String[]{strs});
            List<String> lstId = new ArrayList();
            Iterator var3 = lstStrId.iterator();

            while (var3.hasNext()) {
                String strId = (String) var3.next();
                if (!StringUtils.isEmpty(strId)) {
                    lstId.add(strId);
                }
            }

            return lstId;
        }
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDate dateToLocalDate(Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date localDateToDate(LocalDate localDate) {
        return localDate == null ? null : Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String localDateTimeToStr(LocalDateTime value) {
        return localDateTimeToStr(value, "yyyy-MM-dd");
    }

    public static String localDateTimeToStr(LocalDateTime value, String format) {
        String dateString;
        if (value == null) {
            dateString = "";
        } else {
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(format);
            dateString = value.format(formatDate);
        }

        return dateString;
    }

    public static String localDateToStr(LocalDate value) {
        return localDateToStr(value, "yyyy-MM-dd");
    }

    public static String localDateToStr(LocalDate value, String format) {
        String dateString;
        if (value == null) {
            dateString = "";
        } else {
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(format);
            dateString = value.format(formatDate);
        }

        return dateString;
    }

    public static LocalDateTime strToLocalDateTime(String value) {
        return strToLocalDateTime(value, "yyyy-MM-dd HH:mm:ss");
    }

    public static LocalDateTime strToLocalDateTime(String value, String format) {
        if (value != null && value.trim().length() > 0) {
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(format);

            try {
                return LocalDateTime.parse(value, formatDate);
            } catch (Exception var4) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static LocalDate strToLocalDate(String value) {
        return strToLocalDate(value, "yyyy-MM-dd");
    }

    public static LocalDate strToLocalDate(String value, String format) {
        if (value != null && value.trim().length() > 0) {
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(format);

            try {
                return LocalDate.parse(value, formatDate);
            } catch (Exception var4) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static boolean strToBoolean(String str) {
        return Boolean.parseBoolean(str);
    }

    public static String rgbToHexEncoding(int R, int G, int B) {
        StringBuffer strHex = new StringBuffer();
        String strr = Integer.toHexString(R);
        String strG = Integer.toHexString(G);
        String strB = Integer.toHexString(B);
        strr = strr.length() == 1 ? "0" + strr : strr;
        strG = strG.length() == 1 ? "0" + strG : strG;
        strB = strB.length() == 1 ? "0" + strB : strB;
        strHex.append("#");
        strHex.append(strr.toUpperCase());
        strHex.append(strG.toUpperCase());
        strHex.append(strB.toUpperCase());
        return strHex.toString();
    }
}

