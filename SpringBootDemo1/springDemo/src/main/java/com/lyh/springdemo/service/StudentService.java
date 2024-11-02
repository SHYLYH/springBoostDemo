package com.lyh.springdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.springdemo.bean.Student;

import java.util.List;

public interface StudentService extends IService<Student>  {
    Student getStudent(Long id);
    List<Student> getStudentById2Name(Long id , String name );
    void updateStudent(Student student);
    void removeById(Long id);
    void addStudent(Student student);
}
