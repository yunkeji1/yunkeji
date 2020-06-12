package com.cloudclass.course.annotation;

import java.lang.annotation.*;

/**
 * 功能描述:
 * app登录效验
 * @auther ss
 * @date 2020-6-12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginRequired {
}
