package com.final_pro.jobhuntsystem.mapper;

import com.final_pro.jobhuntsystem.entity.Job;
import com.final_pro.jobhuntsystem.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from stu_info")
    List<Student> selectAllStudents();

    @Select("select * from stu_info where job = #{job}")
    List<Student> selectByJob(int job);

    @Select("select * from stu_info")
    @Results(
            {
                    @Result(column = "stuID", property = "stuID"),
                    @Result(column = "department", property = "department"),
                    @Result(column = "major", property = "major"),
                    @Result(column = "grade", property = "grade"),
                    @Result(column = "GPA", property = "GPA"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "age", property = "age"),
                    @Result(column = "gender", property = "gender"),
                    @Result(column = "job", property = "job", javaType = Job.class,
                            // one表示一对一关系
                            one = @One(select = "com.final_pro.jobhuntsystem.mapper.JobMapper.findJobById")
                    )
            }
    )
    List<Student> selectAllStuAndJob();
}
