package com.graduationaldesign.graduation.util;

import java.util.UUID;

/**
 * @author wuzhuhao
 */
public class IDUtil {
    /**
     * 自拟题目
     */
    private static final String DEFINE = "DF";
    /**
     * 企业题目
     */
    private static final String ENTERPRISE = "ET";
    /**
     * 科研题目
     */
    private static final String SCIENTIFIC_RESEARCH = "SR";

    /**
     * 获取8位不重复随机码（取当前时间戳转化为十六进制）
     *
     * @param time
     * @return
     * @author wuzhuhao
     */
    public static String toHex(long time) {
        return Integer.toHexString((int) time);
    }

    /**
     * 自动生成课题id
     *
     * @param type 1为科研题目，2为企业题目，3为自拟题目
     * @return
     */
    public static String generateSubID(int type) {
        switch (type) {
            case 1:
                return SCIENTIFIC_RESEARCH + toHex(System.currentTimeMillis());
            case 2:
                return ENTERPRISE + toHex(System.currentTimeMillis());
            case 3:
                return DEFINE + toHex(System.currentTimeMillis());
        }
        return DEFINE + toHex(System.currentTimeMillis());
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
