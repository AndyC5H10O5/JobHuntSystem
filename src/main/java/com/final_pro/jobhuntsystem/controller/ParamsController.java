package com.final_pro.jobhuntsystem.controller;

import org.springframework.web.bind.annotation.*;
import com.final_pro.jobhuntsystem.entity.*;

@RestController
public class ParamsController {
    @RequestMapping(value = "/getTest1", method = RequestMethod.GET)
    public String getTest1(){
        return "GET请求";
    }

    @RequestMapping(value = "/getTest2", method = RequestMethod.GET)
    public String getTest2(String transParam, String age){
        System.out.println(age);
        return "hello " + transParam + ", age: " + age;
    }

    @RequestMapping(value = "/getTest3", method = RequestMethod.GET)
    // http://localhost:8088/getTest3?nickname=xxx
    public String getTest3(@RequestParam(value = "nickname", required = false) String name){
        // 将接收参数nickname绑定到方法参数name上（注意：使用此注解代表该参数必须被使用！否则无法访问到该方法；或添加required = false）
        System.out.println("nickname: " + name);
        return "GET请求";
    }

//    @GetMapping("/**")
//    // http://localhost:8088/任意字符/任意多层 （若一个*，则只有一层）
//    public String test(){
//        return "通配符请求";
//    }

    @RequestMapping(value = "/postTest1", method = RequestMethod.POST)
    // 浏览器搜索栏只能发送Get请求，此处需要前端程序ApiFox来访问: http://localhost:8088/postTest1
    public String postTest1(){
        return "POST请求";
    }

    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    // ApiFox: http://localhost:8088/postTest2 (注意：Post请求的参数一般包含在请求体里面，ApiFox：快捷请求 - Body)
    public String postTest2(String username, String password){
        System.out.println("username: " + username);
        System.out.println("password: " + password); // 拿到前端发送的数据
        return "POST请求";
    }

    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    // ApiFox: http://localhost:8088/postTest3 (接收的参数被自动封装成一个”类对象“，须保证接收的参数与User的”属性名“一致)
    public String postTest3(User user){
        System.out.println(user);
        return "POST请求";
    }

    @RequestMapping(value = "/postTest4", method = RequestMethod.POST)
    // ApiFox: http://localhost:8088/postTest4 (@RequestBody注解，表示接收一个”json“文件，需注意json语法的参数类型与User的”属性类型“一致)
    public String postTest4(@RequestBody User user){
        System.out.println(user);
        return "POST请求";
    }
}
