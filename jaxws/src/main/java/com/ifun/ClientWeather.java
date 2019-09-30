package com.ifun;

import com.ifun.wsdl.weather.WeatherWS;
import com.ifun.wsdl.weather.WeatherWSSoap;

import java.util.List;

/**
 * Create by iFun on 2019/09/27
 */
public class ClientWeather {
    public static void main(String[] args) {
        //1.创建服务试图 --<wsdl:service name="xxx"> 节点获取视图对象名称
        WeatherWS service = new WeatherWS();
        //2.获取服务实现类 --<wsdl:portType name="xxx"> 节点获取实现类名称
        WeatherWSSoap port = service.getPort(WeatherWSSoap.class);
        //3.调用方法 -- <portType>节点下<wsdl:operation name="xxx"> 节点获取方法名
        List<String> list = port.getWeather("北京", null).getString();

        for (String s : list) {
            System.out.println(s);
        }
    }
}
