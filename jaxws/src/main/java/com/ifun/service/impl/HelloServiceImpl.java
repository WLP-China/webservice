package com.ifun.service.impl;

import com.ifun.service.HelloService;

import javax.jws.WebService;

/**
 * Create by iFun on 2019/09/27
 */
@WebService(endpointInterface = "com.ifun.service.HelloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + " Welcome";
    }

    @Override
    public String getMessage() {
        return "message";
    }
}
