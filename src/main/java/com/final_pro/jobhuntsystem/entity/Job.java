package com.final_pro.jobhuntsystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("job_info") // 告诉MybatisPlus去找哪个表
public class Job {
    private int id;
    private String company;
    private String job_name;
    private int daily_salary;
    private int work_time;

    // 描述用户的所有订单
    @TableField(exist = false) // 告诉MybatisPlus这个字段在数据库中不存在（Mybatis自己写sql则无所谓）
    private List<Student> students; // 多表查询，一对多
    // Tips：”查询所有学生及其工作“时，返回结果的”job“里又会有”students“，值为null，可以不用理会

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public int getDaily_salary() {
        return daily_salary;
    }

    public void setDaily_salary(int daily_salary) {
        this.daily_salary = daily_salary;
    }

    public int getWork_time() {
        return work_time;
    }

    public void setWork_time(int work_time) {
        this.work_time = work_time;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", job_name='" + job_name + '\'' +
                ", daily_salary=" + daily_salary +
                ", work_time=" + work_time +
                ", students=" + students +
                '}';
    }
}
