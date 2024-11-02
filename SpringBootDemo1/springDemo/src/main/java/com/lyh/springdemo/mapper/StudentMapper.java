package com.lyh.springdemo.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.springdemo.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.jdbc.core.SqlProvider;

import java.util.List;
@DS("test")
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select("select id , name ,age from students where id = #{id}")
    Student selectById(Long id );


    @Select("${sql}")
    List<Student> selectStudents(String sql);


    //最好要用 结构体
    @Update("update students set name =#{name} where id =#{id}")
    void updateByidtoName(Student student);

    @Delete("delete from students where id = #{id}")
    void deleteByid(Long id);

    @Insert("insert into students (id , name ,age) values (#{c.id} , #{c.name} , #{c.age})")
    void addStu(@Param("c")Student student);
}
