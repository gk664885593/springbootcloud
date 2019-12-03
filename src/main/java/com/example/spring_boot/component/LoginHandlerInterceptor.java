package com.example.spring_boot.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUname = request.getSession().getAttribute("loginUname");
        if(loginUname == null){
            //未登录 ， 转发到登陆页面
            request.setAttribute("msg","没有权限请先登陆");
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;
        }else{
            return true;
        }

    }
}
