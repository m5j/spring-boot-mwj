package com.mwj.springbootmwj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringBootMwjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMwjApplication.class, args);
    }

}
