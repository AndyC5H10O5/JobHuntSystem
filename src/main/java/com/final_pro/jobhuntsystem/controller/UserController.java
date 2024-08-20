package com.final_pro.jobhuntsystem.controller;

import com.final_pro.jobhuntsystem.entity.User;
import org.springframework.web.bind.annotation.*;

// 符合RESTful风格的写法：增POST、删DELETE、改PUT、查GET。

@RestController
public class UserController {
    @GetMapping("/user/{id}")
    // http://localhost:8080/user/22331090
    public String getUserById(@PathVariable int id){
        System.out.println(id);
        return "根据id查询用户信息";
    }
    @PostMapping("/user")
    public String save(User user){
        return "添加用户";
    }
    @PutMapping("/user")
    public String update(User user){
        return "更新用户";
    }
    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id){
        System.out.println(id);
        return "根据id删除用户";
    }
}
