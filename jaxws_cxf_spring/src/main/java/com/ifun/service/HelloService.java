package com.ifun.service;

import javax.jws.WebService;

/**
 * 对外发布服务的接口
 * Create by iFun on 2019/09/27
 */
@WebService
public interface HelloService {
    /**
     * 对外发布服务的接口方法
     * @param name
     * @return
     */
    public String sayHello(String name);
}
