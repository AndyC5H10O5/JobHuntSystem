package com.final_pro.jobhuntsystem.mapper;

import com.final_pro.jobhuntsystem.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 是一个mapper组件
public interface UserMapper {
    // Spring会自动“实例化”UserMapper
    @Select("select * from adm_info") // 查询所有管理员
    public List<User> find();

    @Insert("Insert into adm_info values (#{id}, #{name}, #{age}, #{password})")
    public int insert(User user);
}
