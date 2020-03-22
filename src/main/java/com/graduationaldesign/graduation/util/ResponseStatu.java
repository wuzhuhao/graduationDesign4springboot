package com.graduationaldesign.graduation.util;

import com.graduationaldesign.graduation.service.SysdictService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/10 19:30
 */
@Slf4j
public class ResponseStatu {

    /**
     * 添加状态码和封装结果
     *
     * @param status
     * @param result
     * @return
     */
    public static ResponseEntity<Object> response(int status, Result result) {
        return ResponseEntity.status(status).body(result);
    }

    public static ResponseEntity<Object> success(String message) {
        return ResponseStatu.response(HttpStatus.SC_OK, Result.success(message));
    }

    /**
     * 封装有data的response
     *
     * @param result
     * @return
     */
    public static ResponseEntity<Object> success(Object result) {
        String className = result.getClass().getSimpleName().split("_")[0];
        if (result instanceof PageBean) {
            try {
                className = ((PageBean) result).getBeanList().get(0).getClass().getSimpleName().split("_")[0];
            } catch (Exception e) {
                e.printStackTrace();
                log.error("无数据，默认传page类");
            }
        }
        Result result1 = Result.success(result);
        result1.setDict(ApplicationContextProvider.getBean(SysdictService.class).selectByModel(lowerFirstCapse(className)));
        return ResponseStatu.response(HttpStatus.SC_OK, result1);
    }

    public static ResponseEntity<Object> failure(String message) {
        return ResponseStatu.response(HttpStatus.SC_OK, Result.failure(message));
    }

    public static String lowerFirstCapse(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
