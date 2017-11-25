package com.xing.base.interceptor;

import com.xing.admin.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dllo on 17/11/16.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String url = request.getRequestURI();
        // 排除登录请求
        if ("/login".equals(url) || ("/").equals(url)){
            // 放行
            return true;
        }
        ServletContext application = request.getSession().getServletContext();
        Admin admin = (Admin) application.getAttribute("admin");
        if (admin == null){
            // 如果没有登录过需要转发到登录界面
            application.setAttribute("logmsg","你还没登录呢");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
