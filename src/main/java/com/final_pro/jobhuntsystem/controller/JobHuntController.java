package com.final_pro.jobhuntsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.final_pro.jobhuntsystem.entity.Job;
import com.final_pro.jobhuntsystem.entity.Student;
import com.final_pro.jobhuntsystem.mapper.JobMapper;
import com.final_pro.jobhuntsystem.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 现在是控制器，可以接受浏览器请求了。
@CrossOrigin // 最简单的跨域解决方法（允许该控制器被跨域访问）
public class JobHuntController {
    // 云部署：http://www.XXX.com/ [path]
    // 本地： http://localhost:8081/hello   (Tomcat默认:8088;可以在properties文件中修改server.port=80)
    // 本地： http://localhost:8081/hello?transParam=Lucy&age=23     (在？后面传递参数, &后面传递多个参数)
    @GetMapping("/hello") // 浏览器会发送Get请求访问此方法。
    public String hello(String transParam, String age) {
        System.out.println(age);
        return "hello " + transParam + ", age: " + age;
    }

    @Autowired
    JobMapper jobMapper;

    @GetMapping("/job/findAllJob") // 查询所有工作
    // http://localhost:8081/job/findAllJob
    public List<Job> findAllJob(){
        return jobMapper.findJob();
    }

    @DeleteMapping("/job/deleteJob")
    // http://localhost:8081/stu/deleteStudent?stuID=123
    public String delJob(@RequestParam(value = "id") int id){
        // 将接收参数nickname绑定到方法参数name上（注意：使用此注解代表该参数必须被使用！否则无法访问到该方法；或添加required = false）
        int i = jobMapper.delJob(id);
        if(i > 0)
            return "删除成功";
        else
            return "删除失败";
    }

    @PostMapping("/job/addJob")
    public String addJob(Job job){
//        System.out.println("---------------");
//        System.out.println("POST请求参数：");
//        System.out.println("name:" + student.getName() + " major:" + student.getMajor());
//        System.out.println("---------------");
        int i = jobMapper.addJob(job);
        if(i > 0)
            return "添加成功";
        else
            return "添加失败";
    }

    @PutMapping("/job/updateJob")
    public String putJob(Job job){
        int i = jobMapper.updateJob(job);
        if(i > 0)
            return "修改成功";
        else
            return "修改失败";
    }

    @GetMapping("/job/findAllJobMBP") // MyBatisPlus：查询所有工作
    // http://localhost:8081/job/findAllJobMBP
    public List<Job> findAllJobMBP() {
        return jobMapper.selectList(null);
    }

    @GetMapping("/job/findAllJobAndStu") // 查询所有工作及其实习生
    // http://localhost:8081/job/findAllJobAndStu
    public List<Job> findAJaS() {
        return jobMapper.selectAllUserAndOrders();
    }

    @GetMapping("/job/selectJobByMoney") // 使用MybatisPlus自动生成”条件查询“的sql语句
    // http://localhost:8081/job/selectJobByMoney
    public List<Job> selectJobByMoney() {
        QueryWrapper<Job> queryWrapper = new QueryWrapper();
        queryWrapper.ge("daily_salary", "200"); // 查询日薪大于等于150的工作
        return jobMapper.selectList(queryWrapper);
    }

    @GetMapping("/job/findByPage") // MyBatisPlus分页查询
    // http://localhost:8081/job/findByPage
    public IPage findByPage(){
        // 设置起始值及每页条数
        Page<Job> page = new Page<>(0, 3);  // 页描述
        IPage iPage = jobMapper.selectPage(page, null); // 结果集
        return iPage; // 可以直接将IPage返回给前端
    }

    @PostMapping("/job/insert")
    // http://localhost:8081/job/insert
    public String save(Job job){
        System.out.println("---------------");
        System.out.println("post请求参数：");
        System.out.println("company:" + job.getCompany() + " job:" + job.getJobName());
        System.out.println("---------------");
        int i = jobMapper.insert(job);
        if(i > 0)
            return "插入成功";
        else
            return "插入失败";
    }

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/stu/findAllStudents") // 查询所有学生
    // http://localhost:8081/user/findAllStudents
    public List<Student> findAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @GetMapping("/stu/findAllStuAndJob") // 查询所有学生及其实习工作
    // http://localhost:8081/user/findAllStuAndJob
    public List<Student> findASaJ() {
        return studentMapper.selectAllStuAndJob();
    }

    @DeleteMapping("/stu/deleteStudent")
    // http://localhost:8081/stu/deleteStudent?stuID=123
    public String getTest3(@RequestParam(value = "stuID") int stuID){
        // 将接收参数nickname绑定到方法参数name上（注意：使用此注解代表该参数必须被使用！否则无法访问到该方法；或添加required = false）
        int i = studentMapper.delStudent(stuID);
        if(i > 0)
            return "删除成功";
        else
            return "删除失败";
    }

    @PostMapping("/stu/addStudent")
    public String addStudent(Student student){
//        System.out.println("---------------");
//        System.out.println("POST请求参数：");
//        System.out.println("name:" + student.getName() + " major:" + student.getMajor());
//        System.out.println("---------------");
        int i = studentMapper.addStudent(student);
        if(i > 0)
            return "添加成功";
        else
            return "添加失败";
    }

    @PutMapping("/stu/updateStudent")
    public String updateStudent(Student student){
        int i = studentMapper.updateStudent(student);
        if(i > 0)
            return "修改成功";
        else
            return "修改失败";
    }
}
