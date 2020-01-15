package com.graduationaldesign.graduation.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduationaldesign.graduation.util.JsonUtils;
import com.graduationaldesign.graduation.util.Result;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler implements HandlerExceptionResolver{
    private static final Logger logger;

    static {
        logger = LogManager.getLogger(GlobalExceptionHandler.class);
    }

//    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errorPage");
        return mav;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<Object> paramException(Exception e) {
        logger.error("接受表单字段类型错误");
        /*可以在此处加日志输出exception*/
        return ResponseEntity.status(HttpStatus.SC_OK).body(Result.failure("接受表单字段类型错误"));
    }

    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AuthorizationException e) {
        logger.error("没有通过权限验证！", e);
        return "没有通过权限验证！";
    }

    /**
     * 异常默认处理方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
            logger.error("服务器出错", e);
        //如果是ajax请求，就返回一个json格式的出错提示信息
        if (httpServletRequest.getHeader("X-Requested-With") != null) {
            try {
                httpServletResponse.getWriter().println(JsonUtils.objectToJson(Result.failure("服务器出错了")));
            } catch (IOException ex) {
                logger.error("服务器失败时发送错误提示信息失败", ex);
            }
            //返回一个空的ModelAndView表示已经手动生成响应
            //return null表示使用默认的处理方式，等于没处理
            return new ModelAndView();
        } else {
            return new ModelAndView("errorPage");
        }
    }
}

