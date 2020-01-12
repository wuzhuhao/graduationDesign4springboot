package com.graduationaldesign.graduation.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 提供MD5操作
 * @author wanyang3
 * 
 */
public final class MD5Util {

    private MD5Util() {
    }

    /**
     * 转换成十六进制
     *
     * @param b 二进制数组
     * @return
     * @author wanyang3
     */
    public static String byte2hex(byte[] b) { // 二行制转十六进制字符串
        if (b == null) {
            return "";
        }
        StringBuffer hs = new StringBuffer();
        String stmp = null;
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append("0");
            }
            hs.append(stmp);
        }
        return hs.toString();
    }

    /**
     * 计算MD5值
     *
     * @param src 字符串
     * @return
     * @author wanyang3
     */
    public static String MD5(String src) {
        if (src == null) {
            return "";
        }
        byte[] result = null;
        try {
            MessageDigest alg = MessageDigest.getInstance("MD5");
            result = alg.digest(src.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            try {
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        } catch (UnsupportedEncodingException e) {
            try {
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        }
        return byte2hex(result);
    }

    /**
     * 计算MD5值
     *
     * @param src 二进制数组
     * @return
     * @author wanyang3
     */
    public static String MD5(byte[] src) {
        if (src == null) {
            return "";
        }
        byte[] result = null;
        try {
            MessageDigest alg = MessageDigest.getInstance("MD5");
            result = alg.digest(src);
        } catch (NoSuchAlgorithmException e) {
            try {
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        }
        return byte2hex(result);
    }

    /**
     * @param src 二进制数组
     * @return
     * @author wanyang3
     */
    public static byte[] MD5Bytes(byte[] src) {
        byte[] result = null;
        if (src != null) {
            try {
                MessageDigest alg = MessageDigest.getInstance("MD5");
                result = alg.digest(src);
            } catch (NoSuchAlgorithmException e) {
                try {
					throw new Exception(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        }
        return result;
    }

}
