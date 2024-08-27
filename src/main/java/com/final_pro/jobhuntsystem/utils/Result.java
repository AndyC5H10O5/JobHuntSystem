package com.final_pro.jobhuntsystem.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

// 同一返回网络请求结果的方法
@Getter
@Setter
public class Result {
    private Boolean success; // 请求是否成功
    private Integer code;   // 自定义的状态码
    private String message; // 解释信息
    private Map<String, Object> data = new HashMap<>(); // 保存要交给前端的具体信息

    // 把构造方法私有
    private Result(){}

    // 快捷创建类实例 - 请求成功
    public static Result ok(){
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("请求成功");
        return r;
    }

    // 快捷创建类实例 - 请求失败
    public static Result error(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("请求失败");
        return r;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
