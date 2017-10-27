package com.lzl.config;

import com.lzl.service.BaseService;
import com.lzl.service.impl.ConcreteAService;
import com.lzl.service.impl.ConcreteBService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: li_zhilei
 * @Date: create in 11:23 17/10/27.
 * @description:
 */
@Configuration
public class MyConfig {

    @Bean
    public BaseService createAService(){
        return new ConcreteAService();
    }

    @Bean
    public BaseService createBService(){
        return new ConcreteBService();
    }
}
