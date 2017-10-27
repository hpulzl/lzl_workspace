package com.lzl.service.impl;

import com.lzl.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Author: li_zhilei
 * @Date: create in 14:04 17/10/27.
 * @description:
 */
@Service
public class ConcreteBService implements BaseService {
    @Override
    public void doSomeThing() {
        System.out.println("BBB concreteAService do something");
    }
}
