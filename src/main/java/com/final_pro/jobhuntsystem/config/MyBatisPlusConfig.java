package com.final_pro.jobhuntsystem.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        // 配置MyBatisPlus分页查询
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor(); // 创建一个MyBatisPlus拦截器，做mysql查询时都会被拦截做处理
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor(DbType.MYSQL); // 定义一个分页拦截器
        interceptor.addInnerInterceptor(paginationInterceptor); // 注册拦截器
        return interceptor;
    }
}
