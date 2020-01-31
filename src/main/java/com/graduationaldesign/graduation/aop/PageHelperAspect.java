package com.graduationaldesign.graduation.aop;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduationaldesign.graduation.mapper.SubjectMapper;
import com.graduationaldesign.graduation.pojo.Task;
import com.graduationaldesign.graduation.util.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    @Pointcut("execution(public * com.graduationaldesign.graduation.service.*.*WithPage(..))")
    public void serviceFindFunction(){}
    /**
     * 使用around方法 在执行查询方法前执行PageHelper.startWith
     * 在执行查询方法后 将结果封装到PageInfo中
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("serviceFindFunction()")
    public Object serviceImplAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("进入PageHelper AOP");
        //获取连接点方法运行时的入参列表
        Object[] args = proceedingJoinPoint.getArgs();
        //获取连接点的方法签名对象
        Signature signature = proceedingJoinPoint.getSignature();
        //获取连接点所在的类的对象(实例)
        Object target = proceedingJoinPoint.getTarget();
        PageHelper.startPage(Integer.parseInt(args[1].toString()), rootPropeties.getPageSize());

        log.info("方法[{}]开始执行...",signature.getName());
        Object object = proceedingJoinPoint.proceed();
        log.info("方法[{}]执行结束.",signature.getName());

        if(object instanceof PageBean) {
            PageBean pageBean = (PageBean) object;
            pageBean.setPageSize(rootPropeties.getPageSize());
            pageBean.setCurrentPage(Integer.parseInt(args[1].toString()));
            return pageBean;
        }
        return object;
    }

//    public Object test(ProceedingJoinPoint proceedingJoinPoint){
//        log.info("进入PageHelper AOP");
//        //获取连接点方法运行时的入参列表
//        Object[] args = proceedingJoinPoint.getArgs();
//        //获取连接点的方法签名对象
//        Signature signature = proceedingJoinPoint.getSignature();
//        //获取连接点所在的类的对象(实例)
//        Object target = proceedingJoinPoint.getTarget();
//        int totalpage;
//        int totalSize;
//        PageBean<Task> pageBean = new PageBean<>();
//        //计算数据库总数
//        totalSize = (int) taskMapper.countByExample(taskExample);
//        //设置一页的数量
//        pageBean.setPageSize(SubjectMapper.PAGE_SIZE);
//        //设置总数
//        pageBean.setTotalRecord(totalSize);
//        //获取总页数
//        totalpage = pageBean.getTotalPage();
//        //初始化page
//        page = (page<=0)?1:page>totalpage?totalpage:page;
//        pageBean.setCurrentPage(page);
//        PageHelper.startPage(page , SubjectMapper.PAGE_SIZE);
//        List<Task> list =  taskMapper.selectByExample(taskExample);
//        //得到分页的结果对象
//        PageInfo<Task> personPageInfo = new PageInfo<>(list);
//        //得到分页中的person条目对象
//        List<Task> pageList = personPageInfo.getList();
//        pageBean.setBeanList(pageList);
//        return pageBean;
//    }

}