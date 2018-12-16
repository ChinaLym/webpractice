package com.edeclare.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
* Type: LoginRequired
* Description: 该注解所在的方法需要已经登录才能访问
* 	impl:com.edeclare.interceptor.aop.UserInterceptor
* @author LYM
* @date Dec 16, 2018
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {

}
