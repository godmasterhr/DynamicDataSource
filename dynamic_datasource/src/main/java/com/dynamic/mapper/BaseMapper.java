package com.dynamic.mapper;

import com.dynamic.anno.DataSource;
import com.dynamic.pojo.Student;
import com.dynamic.util.DBContextHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/9/30.
 */
@DataSource("base")
public interface BaseMapper {

    public List<Student> findStudentList();
}
