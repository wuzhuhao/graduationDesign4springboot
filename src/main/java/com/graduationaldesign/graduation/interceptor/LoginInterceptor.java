package com.graduationaldesign.graduation.interceptor;


import com.graduationaldesign.graduation.JWT.TokenService;
import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.util.CookieUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    TokenService tokenService;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
            Exception arg3)
            throws Exception {
        // 执行完毕，返回前拦截
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
            ModelAndView arg3)
            throws Exception {
        // 在处理过程中，执行拦截
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2)
            throws Exception {
        // 在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
        // 返回false则不执行拦截
        log.warn("拦截器启动");
        //String uri = request.getRequestURI(); // 获取登录的uri，这个是不进行拦截的
        //if(session.getAttribute("LOGIN_USER")!=null || uri.indexOf("system/login")!=-1) {// 说明登录成功 或者 执行登录功能
        //获取cookie中的token
        String token = CookieUtil.getCookieValue(request, "token");
        if (null == token || StringUtils.isEmpty(token)) {
            log.error("token为空");
            // 拦截后进入登录页面
            response.sendRedirect(request.getContextPath() + "/index.html");
            return false;
        }
        if (tokenService.checkUser(token)) {
            // 登录成功不拦截
            return true;
        } else {
            // 拦截后进入登录页面
            response.sendRedirect(request.getContextPath() + "/index.html");
            return false;
        }
    }

}
