package com.graduationaldesign.graduation.util;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/10 19:30
 */
public class ResponseStatu {
    /**
     * 添加状态码和封装结果
     * @param status
     * @param result
     * @return
     */
    public static ResponseEntity<Object> response(int status,Result result){
        return ResponseEntity.status(status).body(result);
    }

    public static ResponseEntity<Object> success(String message){
        return ResponseStatu.response(HttpStatus.SC_OK,Result.success(message));
    }
    public static ResponseEntity<Object> success(Object result){
        return ResponseStatu.response(HttpStatus.SC_OK,Result.success(result));
    }
    public static ResponseEntity<Object> failure(String message){
        return ResponseStatu.response(HttpStatus.SC_OK,Result.failure(message));
    }

}
