package com.graduationaldesign.graduation.util;

import com.graduationaldesign.graduation.service.SysdictService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

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
                if (((PageBean) result).getBeanList().get(0) instanceof Map) {
                    className = "All";
                }
            } catch (Exception e) {
                className = getListBean(((PageBean) result).getBeanList());
                log.error("无数据，默认传page类");
            }
        }
        Result result1 = Result.success(result);
        result1.setDict(ApplicationContextProvider.getBean(SysdictService.class).selectByModel(lowerFirstCapse(className)));
        return ResponseStatu.response(HttpStatus.SC_OK, result1);
    }

    public static String getListBean(Object bean) {
        Field[] fields = bean.getClass().getDeclaredFields();
        String result = "";
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.getType() == java.util.List.class) {
                // 如果是List类型，得到其Generic的类型
                Type genericType = f.getGenericType();
                result = genericType.getTypeName();
//                if (genericType == null) continue;
//                // 如果是泛型参数的类型
//                if (genericType instanceof ParameterizedType) {
//                    ParameterizedType pt = (ParameterizedType) genericType;
//                    //得到泛型里的class类型对象
//                    Class<?> genericClazz = (Class<?>) pt.getActualTypeArguments()[0];
//                }
            }
        }
        return result;
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
