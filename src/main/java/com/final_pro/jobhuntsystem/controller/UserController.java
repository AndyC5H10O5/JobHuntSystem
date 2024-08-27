package com.final_pro.jobhuntsystem.controller;

import com.final_pro.jobhuntsystem.entity.User;
import com.final_pro.jobhuntsystem.entity.adm_info;
import com.final_pro.jobhuntsystem.mapper.UserMapper;
import com.final_pro.jobhuntsystem.utils.JwtUtils;
import com.final_pro.jobhuntsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 符合RESTful风格的写法：增POST、删DELETE、改PUT、查GET。

@RestController
//@RequestMapping("/user") // 控制器的同一前缀
@CrossOrigin
public class UserController {
    @PostMapping("/user/login") // 登录后获得Token
    // http://localhost:8088/user/login
    // json: {username: andy, password: 123}
    // 如果前端传递的数据是json格式，必须使用对象接收，同时需要添加@RequestBody
    public Result login(@RequestBody User user){
        String token = JwtUtils.generateToken(user.getName());
        return Result.ok().data("token", token);
    }

    public Result info(String token){
        String username = JwtUtils.getClaimsByToken(token).getSubject(); // getSubject获得先前setSubject的用户名称
        /*
         * 使用username查询数据库获得进一步更详细的信息
         */
        String url = ""; // 头像链接（实际上应该从数据库中查出来）
        return Result.ok().data("name", username).data("头像", url);
    }

    @Autowired // 关键注解：注入由Spring自动实例化的UserMapper
    private UserMapper userMapper;

    @GetMapping("/user") // MyBatisPlus自动实现”查询所有用户“的sql语句
    // http://localhost:8088/user
    public List<adm_info> query(){
        List<adm_info> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }
    @PostMapping("/user")
    // ApiFox: http://localhost:8088/user
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
