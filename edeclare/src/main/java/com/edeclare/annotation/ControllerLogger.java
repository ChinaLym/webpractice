package com.edeclare.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
* Type: ControllerLogger
* Description: Controller层的日志记录注解
		加了该注解的所有方法都会记录其 入参，返回值，异常信息
	规则请至 ControllerLoggerAspectJConfig.java
* @author LYM
* @date Dec 16, 2018
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerLogger {
}