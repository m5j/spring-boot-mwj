package com.mwj.springbootmwj.config;

import com.mwj.springbootmwj.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by minwujun on 2021/5/14
 */
@Configuration
public class AppConfig {

    @Bean
    public Student initStudent() {
        Student student = new Student();
        student.setName("小王");
        return student;
    }
}
