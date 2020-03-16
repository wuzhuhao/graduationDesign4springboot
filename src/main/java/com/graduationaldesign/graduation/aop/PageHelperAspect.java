package com.graduationaldesign.graduation.aop;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduationaldesign.graduation.JWT.JWTUtil;
import com.graduationaldesign.graduation.util.CookieUtil;
import com.graduationaldesign.graduation.util.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/31 15:43
 */
@Aspect
@Component
@Slf4j
public class PageHelperAspect {

    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    private static final String AOP_POINTCUT_CONTRELLER = "execution(public * com.graduationaldesign.graduation.controller.*.*(..))";

    @Pointcut("execution(public * com.graduationaldesign.graduation.service.*.*ByPage*(..))")
    public void serviceListFunction() {
    }

    @Pointcut(AOP_POINTCUT_CONTRELLER)
    public void controllerFunction() {
    }

    /**
     * 使用around方法 在执行查询方法前执行PageHelper.startWith 在执行查询方法后 将结果封装到PageInfo中
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("serviceListFunction()")
    public Object serviceAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("进入PageHelper AOP");
        // 获取连接点方法运行时的入参列表
        Object[] args = proceedingJoinPoint.getArgs();
        // 获取连接点的方法签名对象
        Signature signature = proceedingJoinPoint.getSignature();
        // 获取连接点所在的类的对象(实例)
        Object target = proceedingJoinPoint.getTarget();
        try {
            PageHelper.startPage(Integer.parseInt(args[1].toString()),
                    Integer.parseInt(args[2].toString()));
        } catch (Exception e) {
            e.printStackTrace();
            PageHelper.startPage(1,
                    Integer.parseInt(args[2].toString()));
        }

        log.info("方法[{}]开始执行...", signature.getName());
        Object object = proceedingJoinPoint.proceed();
        log.info("方法[{}]执行结束.", signature.getName());

        if (object instanceof PageBean) {
            PageBean pageBean = (PageBean) object;
            //得到分页的结果对象
            PageInfo<Object> pageInfo = new PageInfo<>(pageBean.getBeanList());
            //总页数
            log.info("总页数[{}]", pageInfo.getPages());
            //当前页
            log.info("当前页[{}]", pageInfo.getPageNum());
            //每页页数
            log.info("每页数量[{}]", pageInfo.getPageSize());
            //总数
            log.info("总数[{}]", pageInfo.getTotal());
            pageBean.setTotalRecord((int) pageInfo.getTotal());
            pageBean.setCurrentPage(pageInfo.getPageNum());
            pageBean.setPageSize(pageInfo.getPageSize());
            pageBean.setParams((Map<String, Object>) args[0]);
            return pageBean;
        }
        return object;
    }

    @Around("controllerFunction()")
    public Object controllerAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("进入controller AOP");
        // 获取连接点的方法签名对象
        Signature signature = proceedingJoinPoint.getSignature();
        log.info("方法[{}]开始执行...", signature.getName());
        Object object = proceedingJoinPoint.proceed();
        log.info("方法[{}]执行结束.", signature.getName());
        if (object instanceof ResponseEntity && (!("login".equals(signature.getName()) || "exit".equals(signature.getName())))) {
            String token = CookieUtil.getCookieValue(request, "token");
            if (token == null || token.length() == 0) {
                return object;
            }
            Map<String, Object> userMap = JWTUtil.getUserId(token);
            ResponseEntity responseEntity = (ResponseEntity) object;
            if (responseEntity.getStatusCode().value() == HttpStatus.SC_OK) {
                CookieUtil.setCookie(request, response, "token", JWTUtil.createToken((String) userMap.get("number"), (Integer) userMap.get("type")),
                        CookieUtil.COOKIEMAXTIME);
                log.info("重设[{}]cookie成功.", signature.getName());
            }
            return object;
        }
        return object;
    }

}
