package com.ifun.service.impl;

import com.ifun.service.HelloService;

/**
 * Create by iFun on 2019/09/27
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + " Welcome";
    }
}
