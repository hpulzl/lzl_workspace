package com.lzl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Author: li_zhilei
 * @Date: create in 17:01 17/5/23.
 * @description:
 */
@SpringBootApplication
@ServletComponentScan
public class SpringBoot01Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01Application.class,args);
    }
}
