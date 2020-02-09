package com.graduationaldesign.graduation.aop;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduationaldesign.graduation.util.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Pointcut("execution(public * com.graduationaldesign.graduation.service.*.*ByPage*(..))")
    public void serviceListFunction() {
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
        PageHelper.startPage(Integer.parseInt(args[1].toString()),
                Integer.parseInt(args[2].toString()));

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
            return pageBean;
        }
        return object;
    }

}
