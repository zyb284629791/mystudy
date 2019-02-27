package com.john.consumer;


import com.john.provider.api.HelloService;
import com.john.consumer.proxy.ProxyFactory;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-26 16:39
 */
public class Consumer {

    public static void main(String[] args) {

        HelloService proxy = ProxyFactory.getProxy(HelloService.class);
        String result = proxy.sayHello("hahaha");
        System.out.println("result = " + result);
    }
}
