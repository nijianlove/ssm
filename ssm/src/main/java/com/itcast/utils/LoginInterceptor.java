package com.itcast.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if(handler instanceof DefaultServletHttpRequestHandler){
           return true;
       }
       //如果session不为空
        HttpSession session = request.getSession();
       if(session.getAttribute("user")!=null){
           return true;
       }

       response.sendRedirect(request.getContextPath()+"/index.jsp");
        return false;
    }
}
