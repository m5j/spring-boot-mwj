package com.mwj.springbootmwj.controller;

import com.mwj.springbootmwj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by minwujun on 2021/5/12
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private StudentService studentService;


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}

