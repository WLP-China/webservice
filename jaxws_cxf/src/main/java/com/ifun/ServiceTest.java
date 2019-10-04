package com.ifun;

import com.ifun.service.HelloService;
import com.ifun.service.impl.HelloServiceImpl;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Create by iFun on 2019/09/27
 */
public class ServiceTest {
    public static void main(String[] args) {
        //发布服务的工厂
        JaxWsServerFactoryBean serverFactoryBean = new JaxWsServerFactoryBean();
        //设置服务地址
        serverFactoryBean.setAddress("http://localhost:8000/ws/hello");
        //设置服务接口
        serverFactoryBean.setServiceClass(HelloService.class);
        //设置服务实现类
        serverFactoryBean.setServiceBean(new HelloServiceImpl());

        //拦截器 输入输出监控日志，可观察soap请求、soap响应内容
        serverFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
        serverFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

        //通过工厂创建服务
        serverFactoryBean.create();

        System.out.println("发布服务成功，端口8000...");
    }

}

//wsdl说明书：http://localhost:8000/ws/hello?wsdl