package com.ifun.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 对外发布服务的接口
 * Create by iFun on 2019/09/27
 */
@WebService
public interface HelloService {
    /**
     * 对外发布服务的接口方法
     *
     * @param name
     * @return
     */
    @WebResult(name = "message")
    public String sayHello(@WebParam(name = "name") String name);

    @WebMethod(exclude = true) //exclude为true表示不发布该方法
    public String getMessage();

}
