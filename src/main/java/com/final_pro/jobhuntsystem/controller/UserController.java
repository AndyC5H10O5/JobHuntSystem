package com.final_pro.jobhuntsystem.controller;

import com.final_pro.jobhuntsystem.entity.User;
import com.final_pro.jobhuntsystem.entity.adm_info;
import com.final_pro.jobhuntsystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 符合RESTful风格的写法：增POST、删DELETE、改PUT、查GET。

@RestController
public class UserController {
    @Autowired // 关键注解：注入由Spring自动实例化的UserMapper
    private UserMapper userMapper;

    @GetMapping("/user")
    // http://localhost:8080/user
    public List query(){
        List<adm_info> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }
    @PostMapping("/user")
    // ApiFox: http://localhost:8080/user
    public String save(adm_info adm){
        int i = userMapper.insert(adm);
        if(i > 0)
            return "插入成功";
        else
            return "插入失败";
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
