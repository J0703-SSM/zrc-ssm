package com.xing.admin.interceptor;

import com.xing.admin.domain.Admin;
import com.xing.role.domain.Permissions;
import com.xing.role.domain.Role;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dllo on 17/11/16.
 */
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        ServletContext application = request.getSession().getServletContext();
        Admin admin = (Admin) application.getAttribute("admin");
        for (Role role : admin.getRolList()) {
            for (Permissions permissions : role.getPerList()) {
                if ("adm".equals(permissions.getPerId())){
                    return true;
                }
            }
        }
        request.getRequestDispatcher("/WEB-INF/pages/nopower.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
