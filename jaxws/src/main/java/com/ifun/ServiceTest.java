package com.ifun;

import com.ifun.service.impl.HelloServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * 通过JDK发布WebService
 * 1.创建接口
 * 2.创建接口实现类 + @WebService
 * 3.发布服务Endpoint.publish(String address, Object implementor)
 * <p>
 * Create by iFun on 2019/09/27
 */
public class ServiceTest {

    public static void main(String[] args) {
        //参数1：服务地址  参数2：服务类
        Endpoint.publish("http://localhost:8000/ws/hello", new HelloServiceImpl());
    }
}

//wsdl说明书：http://localhost:8000/ws/hello?wsdl