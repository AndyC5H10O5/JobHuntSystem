package com.final_pro.jobhuntsystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("job_info") // 告诉MybatisPlus去找哪个表
public class Job {
    private int id;
    private String company;
    private String jobName; // 注意：Mybatis将”java的驼峰风格属性名“映射到”数据库表的下划线风格字段名“！！！！！！
    private int dailySalary;
    private int workTime;

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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(int dailySalary) {
        this.dailySalary = dailySalary;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
