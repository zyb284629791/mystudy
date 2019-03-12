package com.john.designpatten.proxy.sta;

import com.john.designpatten.proxy.Aspect;
import com.john.designpatten.proxy.HelloService;
import com.john.designpatten.proxy.HelloServiceImpl;
import com.john.designpatten.proxy.TransactionAspect;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-12 14:20
 */
public class StaticProxy implements HelloService {

    private HelloServiceImpl helloService;

    public StaticProxy(HelloServiceImpl helloServiceImpl) {
        this.helloService = helloServiceImpl;
    }

    private Aspect aspect = new TransactionAspect();

    @Override
    public void sayHello(String name) {
        aspect.before();
        helloService.sayHello("Java");
        aspect.after();
    }

}
