package com.final_pro.jobhuntsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.final_pro.jobhuntsystem.mapper")
public class JobHuntSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobHuntSystemApplication.class, args);
    }

}
