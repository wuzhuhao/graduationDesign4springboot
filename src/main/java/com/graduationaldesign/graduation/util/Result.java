package com.graduationaldesign.graduation.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Zhou Jie on 2017/5/24.
 */
public class Result implements Serializable{
    /**
     * 成功状态
     */
    private static final Integer SUCCESS_STATUS = 200;
    /**
     * 失败状态
     */
    private static final Integer FAILURE_STATUS = 400;
    /**
     * 系统内部错误
     */
    private static final Integer INTERNAL_ERROR_STATUS = 500;
    private static final String SUCCESS_MESSAGE = "success";
    private static final String FAILURE_MESSAGE = "failure";
    private static final String INTERNAL_ERROR_MESSAGE = "internal error";
    //状态
    private Integer status;

    //消息
    private String message;

    //数据
    private Object data;

    //构造方法
    private Result(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //无数据的成功结果
    public static Result success(){
        return new Result(SUCCESS_STATUS,SUCCESS_MESSAGE,null);
    }

    //有数据,有提示信息的成功结果
    public static Result success(String message,Object data){
        return new Result(SUCCESS_STATUS,message,data);
    }

    //有数据的成功结果
    public static Result success(Object data){
        return new Result(SUCCESS_STATUS,SUCCESS_MESSAGE,data);
    }

    //无消息的失败结果
    public static Result failure(){
        return new Result(FAILURE_STATUS,FAILURE_MESSAGE,null);
    }

    //有消息的失败结果
    public static Result failure(String message){
        return new Result(FAILURE_STATUS,message,null);
    }

    //无消息的内部异常结果
    public static Result internalError(){
        return new Result(INTERNAL_ERROR_STATUS,INTERNAL_ERROR_MESSAGE,null);
    }

    //有消息的内部异常结果
    public static Result internalError(String message){
        return new Result(INTERNAL_ERROR_STATUS,message,null);
    }

    //自定义构建结果
    public static Result build(Integer status,String message,Object data){
        return new Result(status,message,data);
    }

    //设置和获取成员变量的方法
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    //json与数据转化核心类
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //没有数据的转化
    public static Result format(String json) {
        try {
            return MAPPER.readValue(json, Result.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //数据是对象的转化
    public static Result formatToPojo(String json, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(json, Result.class);
            }
            JsonNode jsonNode = MAPPER.readTree(json);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("message").asText(), obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //数据是集合的转化
    public static Result formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("message").asText(), obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
