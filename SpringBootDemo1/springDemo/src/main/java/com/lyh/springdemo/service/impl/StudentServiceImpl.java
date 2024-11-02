package com.lyh.springdemo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.springdemo.bean.Student;
import com.lyh.springdemo.mapper.StudentMapper;
import com.lyh.springdemo.service.StudentService;
import com.lyh.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DS("test")
@Service(value ="st")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student getStudent(Long id) {
        Student student = studentMapper.selectById(id);
        return student;
    }
  //and  前面添加空格 不然 sql 报错    -- 先查看sql 又没哟问题
    @Override
    public List<Student> getStudentById2Name(Long id, String name) {
        StringBuffer sqlBuffer = new StringBuffer("select * from students where 1 = 1 ");
        if (id != null) {
            sqlBuffer.append(" and id =" + id);
        }
        if (name != null) {
            sqlBuffer.append(" and name like '%" + SqlUtil.filterUnsafeSql(name) + "%' ");
        }
        String sql = sqlBuffer.toString();
        List<Student> students = studentMapper.selectStudents(sql);
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateByidtoName(student);
    }

    @Override
    public void removeById(Long id) {
        studentMapper.deleteByid(id);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStu(student);
    }

}
