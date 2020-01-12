package com.graduationaldesign.graduation.util;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * IP地址获取工具类
 * @author wanyang3
 * 
 */
public class IPUtil {
	
//    private static final Logger logger = LoggerFactory.getLogger(IPUtil.class);
    private static final Logger logger = Logger.getLogger(IPUtil.class);
    private static String localIpAddress = null;

    /**
     * 获取本机的IP地址
     * @return
     */
    public static String getLocalIpAddr() {
        if (localIpAddress != null) {
            return localIpAddress;
        }
        localIpAddress = System.getProperty("serverIp");

        String[] bondNames = {"bond0", "eth0", "eth1"};
        for (String bondName : bondNames) {
            if (localIpAddress != null){
            	return localIpAddress;}
            try {
                Enumeration<?> e1 = (Enumeration<?>) NetworkInterface.getNetworkInterfaces();

                while (e1.hasMoreElements()) {
                    NetworkInterface ni = (NetworkInterface) e1.nextElement();
                    if (!ni.getName().equals(bondName)) {
                        continue;
                    } else {
                        logger.info(String.format("use %s search LocalIpAddr", bondName));
                        Enumeration<?> e2 = ni.getInetAddresses();
                        while (e2.hasMoreElements()) {
                            InetAddress ia = (InetAddress) e2.nextElement();
                            if (ia instanceof Inet6Address) {continue;}
                            localIpAddress = ia.getHostAddress();
                        }
                        if ("127.0.0.1".equals(localIpAddress)) {
                            localIpAddress = null;
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                localIpAddress = null;
            }
        }

        if (localIpAddress != null){
        	return localIpAddress;}
        InetAddress inet;
        try {
            logger.info(String.format("use %s search LocalIpAddr", "getLocalHost"));
            inet = InetAddress.getLocalHost();
            localIpAddress = inet.getHostAddress();
        } catch (UnknownHostException e) {
            logger.error(e.getMessage(), e);
            return "";
        }

        return localIpAddress;

    }

    /**
     * 获取请求的ip地址
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        if (request == null) {
            return "";
        }
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            ip = ip.substring(0, ip.indexOf(","));
        }
        return ip;
    }
}
