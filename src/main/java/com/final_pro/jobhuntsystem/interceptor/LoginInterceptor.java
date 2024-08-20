package com.final_pro.jobhuntsystem.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // request: 前端发送的请求， response: 给前端返回信息
        System.out.println("LoginInterceptor");
        return true;
    }
}
// 注：拦截器在config包下进行配置