package com.cloudclass.course.exception;

import com.cloudclass.course.util.JsonUtil;
import com.cloudclass.course.util.Result;
import com.cloudclass.course.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 类的功能描述.
 * 自定义异常
 * 用于处理在请求映射和请求处理过程中抛出的异常的类，都要实现HandlerExceptionResolver接口。
 * HandlerExceptionResolver接口有一个方法resolveException，当controller层出现异常之后就会进入到这个方法resolveException
 * @Auther ss
 * @Date 2020-6-12
 */
@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        Logger logger = LoggerFactory.getLogger(MyHandlerExceptionResolver.class);
        //如果请求是ajax 返回json格式
        if (WebUtils.isAjax(request)) {
            try {

                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                //为了系统安全,只让用户看自定义异常错误信息
                if(e instanceof MyException){
                    logger.info("一个ajax请求，发生业务错误,错误内容:"+e.getMessage());
                    Result error = Result.error(e.getMessage());
                    writer.write(JsonUtil.getJsonByObj(error));
                } else {
                    logger.info("一个ajax请求，发生系统错误,错误内容:"+e.getMessage());
                    Result error = Result.error("系统异常,请联系技术人员!");
                    writer.write(JsonUtil.getJsonByObj(error));
                }
                writer.flush();
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }
}
