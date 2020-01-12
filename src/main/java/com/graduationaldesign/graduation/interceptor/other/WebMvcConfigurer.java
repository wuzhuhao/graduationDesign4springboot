package com.graduationaldesign.graduation.interceptor.other;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduationaldesign.graduation.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor handlerInterceptor=new LoginInterceptor();
        //配置拦截路径
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/list");
    }
}
