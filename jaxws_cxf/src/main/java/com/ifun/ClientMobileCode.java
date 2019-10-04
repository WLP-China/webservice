package com.ifun;

import com.ifun.wsdl.mobilecode.MobileCodeWSSoap;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Create by iFun on 2019/10/04
 */
public class ClientMobileCode {
    public static void main(String[] args) {
        //创建cxf代理工厂。利用JaxWsProxyFactoryBean调用服务
        JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
        //设置服务地址
        proxyFactoryBean.setAddress("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
        //设置服务接口
        proxyFactoryBean.setServiceClass(MobileCodeWSSoap.class);
        //获取服务接口实例
        MobileCodeWSSoap mobileCode = proxyFactoryBean.create(MobileCodeWSSoap.class);
        //调用方法
        String result = mobileCode.getMobileCodeInfo("18837191234", "");

//        System.out.println(mobileCode.getClass());//代理对象
        //class com.sun.proxy.$Proxy35 -jdk代理 （chlib代理：$CGLIB123）
        //Java代理：1.静态代理 2.动态代理（jdk接口代理、cglib代理）
        System.out.println(result);
    }
}