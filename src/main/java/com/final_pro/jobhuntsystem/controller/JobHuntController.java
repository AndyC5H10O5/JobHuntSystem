package com.final_pro.jobhuntsystem.controller;

import com.final_pro.jobhuntsystem.entity.Job;
import com.final_pro.jobhuntsystem.entity.Student;
import com.final_pro.jobhuntsystem.mapper.JobMapper;
import com.final_pro.jobhuntsystem.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    JobMapper jobMapper;

    @GetMapping("/user/findAllJobAndStu") // 查询所有工作及其实习生
    // http://localhost:8080/user/findAllJobAndStu
    public List<Job> findAJaS(){
        return jobMapper.selectAllUserAndOrders();
    }

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/user/findAllStuAndJob") // 查询所有学生及其实习工作
    // http://localhost:8080/user/findAllStuAndJob
    public List<Student> findASaJ(){
        return studentMapper.selectAllStuAndJob();
    }

}
