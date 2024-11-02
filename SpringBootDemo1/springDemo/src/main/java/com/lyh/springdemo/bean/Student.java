package com.lyh.springdemo.bean;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="students")
public class Student {
    private Long id;
    private String name;
    private Integer age;
}
