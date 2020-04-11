package com.graduationaldesign.graduation.aop;


import com.alibaba.fastjson.JSONObject;
import com.graduationaldesign.graduation.JWT.JWTUtil;
import com.graduationaldesign.graduation.JWT.TokenService;
import com.graduationaldesign.graduation.controller.Api;
import com.graduationaldesign.graduation.pojo.Operation;
import com.graduationaldesign.graduation.pojo.User;
import com.graduationaldesign.graduation.service.OperationService;
import com.graduationaldesign.graduation.util.CookieUtil;
import com.graduationaldesign.graduation.util.JsonUtils;
import com.graduationaldesign.graduation.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志切面类
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    TokenService tokenService;
    @Autowired
    OperationService operationService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    /**
     * ..表示包及子包 该方法代表controller层的所有方法
     */
    private static final String AOP_POINTCUT_CONTRELLER = "execution(public * com.graduationaldesign.graduation.controller..*.*(..))";

    @Pointcut(AOP_POINTCUT_CONTRELLER)
    public void controllerFunction() {
    }

//    @Pointcut("execution(public * com.graduationaldesign.graduation.controller..*.*(..))")
//    public void controllerMethod() {
//    }


    /**
     * 方法执行前
     *
     * @param joinPoint
     * @throws Exception
     */
//    @Before("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuilder requestLog = new StringBuilder();
        Signature signature = joinPoint.getSignature();
        requestLog
//                .append(((MethodSignature) signature).getMethod().getAnnotation(Api.class).Pojo()).append("\t")
                .append("请求信息：").append("URL = {").append(request.getRequestURI()).append("},\t")
                .append("请求方式 = {").append(request.getMethod()).append("},\t")
                .append("请求IP = {").append(request.getRemoteAddr()).append("},\t")
                .append("类方法 = {").append(signature.getDeclaringTypeName()).append(".")
                .append(signature.getName()).append("},\t");

        // 处理请求参数
        String[] paramNames = ((MethodSignature) signature).getParameterNames();
        Object[] paramValues = joinPoint.getArgs();
        int paramLength = null == paramNames ? 0 : paramNames.length;
        if (paramLength == 0) {
            requestLog.append("请求参数 = {} ");
        } else {
            requestLog.append("请求参数 = [");
            for (int i = 0; i < paramLength - 1; i++) {
                requestLog.append(paramNames[i]).append("=").append(JSONObject.toJSONString(paramValues[i])).append(",");
            }
            requestLog.append(paramNames[paramLength - 1]).append("=").append(JSONObject.toJSONString(paramValues[paramLength - 1])).append("]");
        }

        log.info(requestLog.toString());
    }


    /**
     * 方法执行后
     *
     * @param result
     * @throws Exception
     */
//    @AfterReturning(returning = "result", pointcut = "controllerMethod()")
    public void logResultInfo(ResponseEntity<Object> result) throws Exception {
        log.info("请求结果：" + result.getStatusCode().value() + "\t");
    }

    @Around("controllerFunction()")
    public Object controllerAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("进入controller AOP");
        Signature signature = proceedingJoinPoint.getSignature();
        log.info("方法[{}]开始执行...", signature.getName());
        Object object = proceedingJoinPoint.proceed();
        log.info("方法[{}]执行结束.", signature.getName());
        if (object != null) {
            //记录日志
            try {
                takeNoteLog(signature, (ResponseEntity) object, proceedingJoinPoint);
            } catch (Exception e) {
                log.error("日记系统出错");
            }
            //重设cookie
            resetCookie(signature, object);
        }
        return object;
    }

    private void takeNoteLog(Signature signature, ResponseEntity result, ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        //方法名字
        String methodName = signature.getName();
        //请求方式
        String requestMethod = request.getMethod();
        //请求连接
        String requestURI = request.getRequestURI();
        //请求ip
        String ip = request.getRemoteAddr();
        //请求状态
        String status = "失败";
        //显示标题
        StringBuilder title = new StringBuilder();
        //请求code
        int code = result.getStatusCode().value();
        Api Api = (Api) signature.getDeclaringType().getAnnotation(Api.class);
        String pojo = Api.Pojo();
        String description = Api.description();
        User user = null;
        String userType = "未知用户";
        String userPojo = "UNKNOWN";
        String userName = "UNKNOWN";
        try {
            try {
                user = tokenService.getUserByToken(request);
            } catch (Exception e) {
                log.error("系统用户是登陆");
                user = (User) ((Result) result.getBody()).getData();
            }
            //用户类型
            userType = user.findUserType();
            userPojo = user.getClass().getSimpleName().split("_")[0];
            userName = user.findUserName();
        } catch (Exception e) {
            log.error("结果类型错误");
        }
        if (code == HttpStatus.SC_OK) {
            status = "成功";
        }
        title.append(userType + " ").append(userName + " ");
        if (requestMethod.equals("DELETE")) {
            title.append("删除了");
        } else if (requestMethod.equals("GET")) {
            if (methodName.indexOf("exit") != -1) {
                title.append("退出了系统");
            } else {
                return;
//                title.append("查询了");
            }
        } else {
            if (methodName.indexOf("update") != -1 || methodName.indexOf("Change") != -1) {
                title.append("修改了");
            } else if (methodName.indexOf("add") != -1 || methodName.indexOf("insert") != -1) {
                title.append("增加了");
            } else if (methodName.indexOf("login") != -1) {
                title.append("登陆了系统");
            } else {
                log.error("方法名字翻车了");
            }
        }
        // 处理请求参数
        String[] paramNames = ((MethodSignature) signature).getParameterNames();
        Object[] paramValues = proceedingJoinPoint.getArgs();
        int paramLength = null == paramNames ? 0 : paramNames.length;
        StringBuilder requestLog = new StringBuilder();
        if (paramLength == 0) {
            requestLog.append("请求参数 = {} ");
        } else {
            requestLog.append("请求参数 = [");
            for (int i = 0; i < paramLength - 1; i++) {
                requestLog.append(paramNames[i]).append("=").append(JSONObject.toJSONString(paramValues[i])).append(",");
            }
            requestLog.append(paramNames[paramLength - 1]).append("=").append(JSONObject.toJSONString(paramValues[paramLength - 1])).append("]");
        }
        title.append("_" + pojo).append("(" + description + ")");
        userPojo += "_" + userName;
        Map<String, Object> map = new HashMap<>();
        map.put("methodName", methodName);
        map.put("requestMethod", requestMethod);
        map.put("requestURI", requestURI);
        map.put("ip", ip);
        map.put("status", status);
        map.put("title", title.toString());
        map.put("code", code);
        map.put("requestParams", requestLog);
        Operation operation = new Operation();
        operation.setOperaRole(userPojo);
        operation.setOperaTime(new Date());
        String json = JsonUtils.objectToJson(map);
        logNumber(user, map);
        operation.setOperaContent(json);
        operationService.insertSelective(operation);
    }

    private void logNumber(User user, Map<String, Object> map) throws Exception {
        String modelName = "";
        String dayName = Day.getValue(new Date());
        if (map.get("code").equals(200) && (map.get("requestURI").toString().indexOf("/report/update") != -1 || map.get("requestURI").toString().indexOf("/report/listUpdate") != -1)) {
            modelName = "update:" + "report";
        } else if (map.get("code").equals(200) && map.get("requestURI").toString().indexOf("/login") != -1) {
            modelName = "login:" + UserType.getValue(user.findUserType());
        } else {
            return;
        }
        String numberString = stringRedisTemplate.opsForValue().get(modelName + ":" + dayName);
        int number = (numberString == null ? 0 : Integer.parseInt(numberString)) + 1;
        stringRedisTemplate.opsForValue().set(modelName + ":" + dayName, number + "");
    }

    private void resetCookie(Signature signature, Object object) throws Exception {
        if (object instanceof ResponseEntity && (!("login".equals(signature.getName()) || "exit".equals(signature.getName())))) {
            String token = CookieUtil.getCookieValue(request, "token");
            if (!(token == null || token.length() == 0)) {
                Map<String, Object> userMap = JWTUtil.getUserId(token);
                ResponseEntity responseEntity = (ResponseEntity) object;
                if (responseEntity.getStatusCode().value() == HttpStatus.SC_OK) {
                    CookieUtil.setCookie(request, response, "token", JWTUtil.createToken((String) userMap.get("number"), (Integer) userMap.get("type")),
                            CookieUtil.COOKIEMAXTIME);
                    log.info("重设[{}]cookie成功.", signature.getName());
                }
            }
//            Map<String, Object> userMap = JWTUtil.getUserId(token);
//            ResponseEntity responseEntity = (ResponseEntity) object;
//            if (responseEntity.getStatusCode().value() == HttpStatus.SC_OK) {
//                CookieUtil.setCookie(request, response, "token", JWTUtil.createToken((String) userMap.get("number"), (Integer) userMap.get("type")),
//                        CookieUtil.COOKIEMAXTIME);
//                log.info("重设[{}]cookie成功.", signature.getName());
//            }
//            return object;
        }
    }
}
