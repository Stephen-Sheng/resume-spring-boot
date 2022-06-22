package com.resume.resumespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.resume.resumespringboot.mapper")
public class ResumeSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeSpringBootApplication.class, args);
    }

}
