package com.dynamic.controller;

import com.dynamic.anno.DataSource;
import com.dynamic.pojo.Student;
import com.dynamic.service.BaseService;
import com.dynamic.util.DBContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/9/30.
 */
@Controller
@DataSource("slave")
public class IndexController {

    @Autowired
    private BaseService baseService;

    @RequestMapping("/dynamic")
    public String toIndex(){
        List<Student> studentList = baseService.findStudentList();
        System.out.println(studentList);
        return "dynamic";
    }

}
