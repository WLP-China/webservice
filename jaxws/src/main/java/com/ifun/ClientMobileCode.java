package com.ifun;

import com.ifun.wsdl.mobilecode.MobileCodeWS;
import com.ifun.wsdl.mobilecode.MobileCodeWSSoap;

/**
 * Create by iFun on 2019/09/27
 */
/*
1. 通过wsimport生成客户端代码
2. 查看wsdl说明书
3. 按照说明书编程
 */
public class ClientMobileCode {
    public static void main(String[] args) {
        //1.创建服务试图 --<wsdl:service name="xxx"> 节点获取视图对象名称
        MobileCodeWS service = new MobileCodeWS();
        //2.获取服务实现类 --<wsdl:portType name="xxx"> 节点获取实现类名称
        MobileCodeWSSoap port = service.getPort(MobileCodeWSSoap.class);
        //3.调用方法 -- <portType>节点下<wsdl:operation name="xxx"> 节点获取方法名
        String result = port.getMobileCodeInfo("18837191234", "");

        System.out.println(result);
    }
}
