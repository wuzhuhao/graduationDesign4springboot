package com.graduationaldesign.graduation.aop;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * 事务配置
 *
 * @Author: wuzhuhao
 * @Date: 2020/2/4 14:37
 */
@Aspect
@Configuration
@Slf4j
public class TransactionManagerConfig {

    private static final int TX_METHOD_TIMEOUT = 500;
    /*定义切点变量：拦截test.spring包下所有类的所有方法,返回值类型任意的方法*/
    private static final String AOP_POINTCUT_EXPRESSION = "execution(public * com.graduationaldesign.graduation.service.*.*(..))";
    @Autowired
    private PlatformTransactionManager transactionManager;

    /**
     * @description springBoot事务配置
     */
    @Bean
    public TransactionInterceptor TxAdvice() {
        /*事务管理规则，声明具备事务管理的方法名*/
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        /*只读事物、不做更新删除等*/
        /*当前存在事务就用当前的事务，当前不存在事务就创建一个新的事务*/
        RuleBasedTransactionAttribute readOnlyRule = new RuleBasedTransactionAttribute();
        /*设置当前事务是否为只读事务，true为只读*/
        readOnlyRule.setReadOnly(true);
        /* transactiondefinition 定义事务的隔离级别；
         * PROPAGATION_NOT_SUPPORTED事务传播级别5，以非事务运行，如果当前存在事务，则把当前事务挂起*/
        readOnlyRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
        RuleBasedTransactionAttribute requireRule = new RuleBasedTransactionAttribute();
        /*抛出异常后执行切点回滚*/
        requireRule.setRollbackRules(
                Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        /*PROPAGATION_REQUIRED:事务隔离性为1，若当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。 */
        requireRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        /*设置事务失效时间，如果超过5秒，则回滚事务*/
        requireRule.setTimeout(TX_METHOD_TIMEOUT);
        Map<String, TransactionAttribute> txMap = new HashMap<>();
//        txMap.put("add*", requireRule);
//        txMap.put("save*", requireRule);
        txMap.put("insert*", requireRule);
//        txMap.put("update*", requireRule);
//        txMap.put("delete*", requireRule);
//        txMap.put("remove*", requireRule);

//        txMap.put("get*", readOnlyRule);
//        txMap.put("query*", readOnlyRule);
//        txMap.put("find*", readOnlyRule);
//        txMap.put("select*", readOnlyRule);
        source.setNameMap(txMap);
        TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, source);
        return txAdvice;
    }

    /**
     * @description 利用AspectJExpressionPointcut设置切面=切点+通知（写成内部bean的方式）
     */
    @Bean
    public Advisor txAdviceAdvisor() {
        /* 声明切点的面
         * 切面（Aspect）：切面就是通知和切入点的结合。通知和切入点共同定义了关于切面的全部内容——它的功能、在何时和何地完成其功能。
         * */
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        /*声明和设置需要拦截的方法,用切点语言描写*/
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        /*设置切面=切点pointcut+通知TxAdvice*/
        return new DefaultPointcutAdvisor(pointcut, TxAdvice());
    }
}
