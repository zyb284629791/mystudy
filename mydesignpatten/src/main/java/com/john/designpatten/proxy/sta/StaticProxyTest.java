package com.john.designpatten.proxy.sta;

import com.john.designpatten.proxy.HelloServiceImpl;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-12 14:55
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        HelloServiceImpl helloService = new HelloServiceImpl();
        StaticProxy staticProxy = new StaticProxy(helloService);
        staticProxy.sayHello("Java");
    }
}
