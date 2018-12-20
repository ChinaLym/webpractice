package com.edeclare.aop.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.edeclare.annotation.LoginRequired;
/**
* Type: LoginRequiredInterceptor
* Description: 实现注解(com.edeclare.annotation.LoginRequired)
* @author LYM
* @date Dec 16, 2018
 */
public class LoginRequiredInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        if (handler instanceof HandlerMethod) {
            LoginRequired loginRequired = findAnnotation((HandlerMethod) handler, LoginRequired.class);
            //没有声明需要权限,或者声明不验证权限
            if(loginRequired==null){
                return true;
            }else{
                String token=request.getHeader("token");
                if(StringUtils.isEmpty(token)){
                    token=request.getParameter("token");
                }
                //在这里实现自己的权限验证逻辑
        		//获得session对象  user
        		Object user = request.getSession().getAttribute("user");
        		if(user != null) {
        			return true;//放行
        		}else {
        			request.getRequestDispatcher("login").forward(request, response);
        			return false;
        		}
                /*
				if(!StringUtils.isEmpty(token)){//如果验证成功返回true（这里直接写false来模拟验证失败的处理）
                    return true;
                }else{//如果验证失败
                    response.getWriter().write("您还未登录");
                    return false;
                }
       				*/
            }
        }else{
            return true;
        }
	}
	
	private <T extends Annotation> T findAnnotation(HandlerMethod handler, Class<T> annotationType) {
        T annotation = handler.getBeanType().getAnnotation(annotationType);
        if (annotation != null) {
        	return annotation;
        }
        return handler.getMethodAnnotation(annotationType);
    }
	
}
