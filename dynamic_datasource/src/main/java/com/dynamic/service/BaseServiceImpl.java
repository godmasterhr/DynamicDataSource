package com.dynamic.service;

import com.dynamic.mapper.BaseMapper;
import com.dynamic.pojo.Student;
import com.dynamic.util.DBContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/30.
 */
@Service
public class BaseServiceImpl implements BaseService{

    @Autowired
    private BaseMapper baseMapper;

    public List<Student> findStudentList() {


        System.out.println(DBContextHolder.getDBType());
        return baseMapper.findStudentList();
    }
}
