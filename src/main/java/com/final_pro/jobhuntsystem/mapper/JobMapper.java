package com.final_pro.jobhuntsystem.mapper;

import com.final_pro.jobhuntsystem.entity.Job;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobMapper {
    @Select("select * from job_info") // 查询所有工作
    List<Job> findJob();

    @Select("select * from job_info where id = #{id}") // 查询指定id的工作
    List<Job> findJobById(int id);

    @Insert("Insert into adm_info values (#{id}, #{name}, #{age}, #{password})")
    int insert(Job job);

    /*
     * MyBatis多表查询（关键）
     */
    @Select("select * from job_info") // select * from job_info, stu_info where stu_info.job = job_info.id ???
    @Results(       // 使用Results注解后，即使名字一致，所有的映射都要自己手动完成
            {       // Results里面可以传入多个Result
                    @Result(column = "id", property = "id"),    // 定义具体映射，前面表示"表"里面的值，后面表示"类"里面的值
                    @Result(column = "company", property = "company"),
                    @Result(column = "job_name", property = "job_name"),
                    @Result(column = "daily_salary", property = "daily_salary"),
                    @Result(column = "work_time", property = "work_time"),
                    // 核心代码：多表查询
                    @Result(column = "id", property = "students", javaType = List.class,
                            // many告诉 MyBatis 这是一个”一对多“的关系，@Many注解表示要查询多个数据
                            many = @Many(select = "com.final_pro.jobhuntsystem.mapper.StudentMapper.selectByJob")
                            //                                                       哪个Mapper <-- . --> 哪个方法（传入id）
                            // 查询结果最终赋值给students属性
                    )
            }
    )
    List<Job> selectAllUserAndOrders(); // 查询所有工作及其所有的实习生
    /*
     * MyBatis多表查询（关键）
     */
}
