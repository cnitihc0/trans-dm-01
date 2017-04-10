package com.trans.webapp.Interceptor;


import com.trans.webapp.model.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截未登录的用户信息
 * @author mashaobo
 * @date 17/2/25
 * @blog http://blog.csdn.net/cnitihc0
 * @email cnitihc0@163.com
 */
public class UserSecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //验证用户是否登陆
        Object obj = request.getSession().getAttribute("cur_user");
        if (obj == null || !(obj instanceof UserEntity)) {
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}