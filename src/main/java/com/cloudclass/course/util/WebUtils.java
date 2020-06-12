package com.cloudclass.course.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 类的功能描述.
 *
 * @Auther ss
 * @Date 2020-6-12
 */

public class WebUtils {

    /**
     * 判断请求是否是ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        String accept = request.getHeader("accept");
        if(accept != null && accept.indexOf("application/json") > -1 || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)){
            return true;
        }
        return false;
    }
}
