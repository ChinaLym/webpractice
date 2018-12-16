package com.edeclare.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
* Type: ServiceLogger
* Description: service层的日志记录注解
		加了该注解的所有方法都会记录其 入参，返回值，异常信息
	若impl中的方法为service层的实现，则需要加该注解（一般都要加）
	否则不需要（如数据安全校验方法不需要加）
* @author LYM
* @date Dec 16, 2018
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceLogger {
}