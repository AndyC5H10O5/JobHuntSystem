package com.final_pro.jobhuntsystem.mapper;

import com.final_pro.jobhuntsystem.entity.Multi;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MultiMapper {
    @Select("select * from stu_job")
    List<Multi> findMulti();

    @Insert("insert into stu_job (id, stu_id, job_id) values (#{id}, #{stuId}, #{jobId})")
    int addMulti(Multi multi);

    @Delete("delete from stu_job where id = #{id}")
    int delMulti(int id);

    @Update("update stu_job SET id=#{id}, stu_id=#{stuId}, job_id=#{jobId}")
    int updateMulti(Multi multi);
}
