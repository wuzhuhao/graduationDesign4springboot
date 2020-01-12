package com.graduationaldesign.graduation.interceptor.other;

import com.graduationaldesign.graduation.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 配置静态资源访问
 */
//@Configuration
//    报错Could not resolve view with name 'login' in servlet with name 'dispatcherServlet'
    /*要重新配置解析页面类*/
public class MyWebMvcConfigurationSupport extends WebMvcConfigurationSupport {


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/list");
//                .excludePathPatterns("/emp/toLogin","/emp/login","/js/**","/css/**","/images/**");
        super.addInterceptors(registry);
    }

    /**
     * 重写 父类 WebMvcConfigurationSupport 中的 addResourceHandlers 方法 可以实现 静态资源的访问
     * addResourceHandler 相对路径 项目中 resources 文件夹下文件访问
     * addResourceLocations 绝对路径 url 直接可以访问 resources 下的访问
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 重写 父类 WebMvcConfigurationSupport 中的 addViewControllers 方法 可以实现 页面跳转
     * addViewController 设置项目路径根路径
     * setViewName 设置访问根路径跳转到的页面
     * @param registry
     */
//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/webdiarysmm").setViewName("list");
//        super.addViewControllers(registry);
//    }
}
