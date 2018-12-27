package com.edeclare.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
* Type: ServiceLoggerAspectJConfig
* Description: 
* com.edeclare.service.impl中所有以ServiceImpl结尾的类中的所有public方法
* 或者添加@ServiceLogger注解的方法，都会前后记录日志及异常
* @author LYM
* @date Dec 16, 2018
 */
@Aspect
@Component("ServiceLoggerAspectJConfig")
public class ServiceLoggerAspectJConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLoggerAspectJConfig.class);

    //定义一个切点,代表service下所有public方法或者添加@ServiceLogger注解的方法，都会前后记录日志及异常
    @Pointcut("execution(public * com.edeclare.service.impl.*ServiceImpl.*(..)) " +
            "|| @annotation(com.edeclare.annotation.ServiceLogger)")
    public void log() {}

    /**
     * Title: beforeServiceLog
     * Description: 进入方法前要做的事情：记录方法名和入参
     * @param joinPoint
     */
    @Before("log()")
    public void beforeServiceLog(JoinPoint joinPoint) {
    	Object[] args = joinPoint.getArgs();    	
    	StringBuilder sb = new StringBuilder(joinPoint.getSignature().toShortString());
	    sb.append("--entry args : ");
	    sb.append(Arrays.toString(args));
	    LOGGER.info(sb.toString());
    }

    /**
     * Title: afterServiceLog
     * Description:  切点所在函数正常返回之后要做的事情：记录方法名和返回值
     * @param joinPoint 切入点
     * @param returnObject	返回值（返回的数据）
     */
    @AfterReturning(value = "log()", returning = "returnObject")
    public void afterServiceLog(JoinPoint joinPoint, Object returnObject) {
    	StringBuilder sb = new StringBuilder(joinPoint.getSignature().toShortString());
	    sb.append("--return object : ");
	    if (returnObject == null) {
	    	sb.append("null.");
		}else {
			sb.append(returnObject.toString());
		}
	    LOGGER.info(sb.toString());
    }
    
    /**
     * Title: handlerExcetionLog
     * Description: 出现异常要做的事情：记录方法名，异常类型和描述
     * @param joinPoint	切点
     * @param exception	异常
     */
    @AfterThrowing(value = "log()", throwing = "exception")
	public void handlerExcetionLog(JoinPoint joinPoint, Exception exception) {
		// 获得类名和方法名称
	    StringBuilder sb = new StringBuilder(joinPoint.getSignature().toShortString());
	    sb.append("--exception! : ");
	    sb.append(exception.getClass());
	    sb.append(" : ");
	    sb.append(exception.getMessage());
	    LOGGER.info(sb.toString());
    }
}