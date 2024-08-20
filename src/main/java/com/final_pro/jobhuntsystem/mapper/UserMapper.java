package com.final_pro.jobhuntsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_pro.jobhuntsystem.entity.User;
import com.final_pro.jobhuntsystem.entity.adm_info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 是一个mapper组件
public interface UserMapper extends BaseMapper<adm_info> {
//    @Select("select * from adm_info") // 查询所有管理员
//    public List<User> find();
//
//    @Insert("Insert into adm_info values (#{id}, #{name}, #{age}, #{password})")
//    public int insert(User user);

    /*
     * mybatisPlus会“自动”找到数据库表，前提是“类名与表名一致”，且默认类属性与表属性一一对应。
     * (也可以在“非同名类”前加入注解 “ @TableName(xxx) ”!!!)
     */
}
