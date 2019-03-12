package com.john.designpatten.proxy.dyn;

import com.john.designpatten.proxy.HelloService;
import com.john.designpatten.proxy.HelloServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-12 15:00
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        HelloServiceImpl helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) Proxy.newProxyInstance(InvocationHandlerImpl.class.getClassLoader(), helloService.getClass().getInterfaces(), new InvocationHandlerImpl(helloService));
        proxy.sayHello("Java");
    }
}
