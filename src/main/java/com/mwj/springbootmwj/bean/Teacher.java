package com.mwj.springbootmwj.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by minwujun on 2021/5/14
 */
@Data
@Component
public class Teacher {
    @Value("李老师")
    private String name;
}
