package com.graduationaldesign.graduation.util;

import com.graduationaldesign.graduation.service.SysdictService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/10 19:30
 */
@Slf4j
public class ResponseStatus {

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
        return ResponseStatus.response(HttpStatus.SC_OK, Result.success(message));
    }

    /**
     * 封装有data的response
     *
     * @param result
     * @return
     */
    public static ResponseEntity<Object> success(Object result, Object controller) {
        String className = result.getClass().getSimpleName().split("_")[0];
        if (result instanceof PageBean) {
            try {
                className = ((PageBean) result).getBeanList().get(0).getClass().getSimpleName().split("_")[0];
                if (((PageBean) result).getBeanList().get(0) instanceof Map) {
                    className = "All";
                }
            } catch (Exception e) {
                className = controller.getClass().getSimpleName().split("_")[0].substring(0, controller.getClass().getSimpleName().split("_")[0].indexOf("Controller"));
                log.error("List无数据传Controller层的类名");
            }
        }
        Result result1 = Result.success(result);
        result1.setDict(ApplicationContextProvider.getBean(SysdictService.class).selectByModel(lowerFirstCapse(className)));
        return ResponseStatus.response(HttpStatus.SC_OK, result1);
    }

    public static ResponseEntity<Object> failure(String message, Object controller) {
        String className = controller.getClass().getSimpleName().split("_")[0].substring(0, controller.getClass().getSimpleName().split("_")[0].indexOf("Controller"));
        Result result1 = Result.failure(message);
        result1.setDict(ApplicationContextProvider.getBean(SysdictService.class).selectByModel(lowerFirstCapse(className)));
        return ResponseStatus.response(HttpStatus.SC_OK, result1);
    }

    public static String lowerFirstCapse(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
