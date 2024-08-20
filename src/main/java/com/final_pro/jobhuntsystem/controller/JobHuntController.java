package com.final_pro.jobhuntsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 现在是控制器，可以接受浏览器请求了。
public class JobHuntController {
    // 云部署：http://www.XXX.com/ [path]
    // 本地： http://localhost:8080/hello   (Tomcat默认:8080;可以在properties文件中修改server.port=80)
    // 本地： http://localhost:8080/hello?transParam=Lucy&age=23     (在？后面传递参数, &后面传递多个参数)
    @GetMapping("/hello") // 浏览器会发送Get请求访问此方法。
    public String hello(String transParam, String age){
        System.out.println(age);
        return "hello " + transParam + ", age: " + age;
    }
}
