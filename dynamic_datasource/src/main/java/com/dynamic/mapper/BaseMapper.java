package com.dynamic.mapper;

import com.dynamic.pojo.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/9/30.
 */
public interface BaseMapper {

    public List<Student> findStudentList();
}
