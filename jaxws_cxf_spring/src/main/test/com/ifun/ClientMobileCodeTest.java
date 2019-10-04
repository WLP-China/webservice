package com.ifun;

import com.ifun.wsdl.mobilecode.MobileCodeWSSoap;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientMobileCodeTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_ws_client.xml");

        MobileCodeWSSoap mobileCodeWSSoap = context.getBean(MobileCodeWSSoap.class);
        String result = mobileCodeWSSoap.getMobileCodeInfo("18837191234", "");

        System.out.println(result);
    }

}