package com.final_pro.jobhuntsystem.controller;

import com.final_pro.jobhuntsystem.entity.Job;
import com.final_pro.jobhuntsystem.entity.Multi;
import com.final_pro.jobhuntsystem.mapper.MultiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 现在是控制器，可以接受浏览器请求了。
@CrossOrigin // 最简单的跨域解决方法（允许该控制器被跨域访问）
public class MultiController {
    @Autowired
    MultiMapper MultiMapper;

    @GetMapping("/multi/findAllMulti") // 查询所有工作
    public List<Multi> findAllMulti(){
        return MultiMapper.findMulti();
    }

    @DeleteMapping("/multi/deleteMulti")
    public String delMulti(@RequestParam(value = "id") int id){
        int i = MultiMapper.delMulti(id);
        if(i > 0)
            return "删除成功";
        else
            return "删除失败";
    }
    @PostMapping("/multi/addMulti")
    public String addMulti(Multi multi){
        int i = MultiMapper.addMulti(multi);
        if(i > 0)
            return "添加成功";
        else
            return "添加失败";
    }

    @PutMapping("/multi/updateMulti")
    public String putMulti(Multi multi){
        int i = MultiMapper.updateMulti(multi);
        if(i > 0)
            return "修改成功";
        else
            return "修改失败";
    }
}
