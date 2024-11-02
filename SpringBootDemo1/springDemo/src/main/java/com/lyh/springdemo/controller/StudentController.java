package com.lyh.springdemo.controller;


import com.lyh.springdemo.bean.Student;
import com.lyh.springdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * 层次：controller  -- service -- mapper  +bean
 * controller：处理URL
 *              重点: 注释  URL的格式
 *              计算交给service
 * service：定义 一个接口：声明方法  继承IService接口
 *          实现这个接口：
 *          处理sql代码  将sql写完
 *
 * mapper：方法的具体实现的代码
 *          有继承BaseMapper
 *          主要是实现sql代码
 *          有很多和curd相关的的注释
 *
 */

@RestController

public class StudentController {
    @Autowired    //将其他类注入到该类中，并可以调用注入类的方法
    @Qualifier(value = "st")  //声明使用那个service层
    StudentService studentService;//因为每个方法都会声明studentservice，不如在方法之外提前声明  要用到Autowired注释

    //动态参数获取
    @GetMapping("/getById2Name/{id}/{name}")
    public List<Student> getById2Name(@PathVariable(value = "id") Long id, @PathVariable(value = "name") String name) {

        List<Student> studentList = studentService.getStudentById2Name(id, name);
        return studentList;
    }

    //修改
    // == /update?id=1&name=xx
    @PostMapping("/update")
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return "success";
    }


    //查询
    //selecet/12
    @GetMapping("/select/{id}")
    public Student getStudents(@PathVariable("id") Long id) {
        Student student = studentService.getStudent(id);
        return student;
    }


    //删除
    @PostMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.removeById(id);
        return "success";
    }


    //添加
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "success";
    }


    // mybais-plus  ---
    @GetMapping("/student/list")
    public List<Student> getStudentList() {
        List<Student> list = studentService.list();
        return list;
    }

    @GetMapping("/student")
    public Student getStudent(@RequestParam("id") Long id) {
        return studentService.getById(Long.valueOf(id));
    }
    @PostMapping("/student")
    public String saveStudent(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
        return "sucess";
    }
}
