package com.final_pro.jobhuntsystem.config;

import com.final_pro.jobhuntsystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 使”配置类“生效，SpringBoot会自动读取这个类
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // 添加拦截器，并添加拦截哪些路径（否则所有路劲都会被拦截）
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**"); // 拦截user路径下的请求
    }
}
