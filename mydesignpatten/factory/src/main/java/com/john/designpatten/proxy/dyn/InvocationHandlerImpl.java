package com.john.designpatten.proxy.dyn;

import com.john.designpatten.proxy.Aspect;
import com.john.designpatten.proxy.HelloServiceImpl;
import com.john.designpatten.proxy.TransactionAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-12 14:21
 */
public class InvocationHandlerImpl implements  InvocationHandler{


    private HelloServiceImpl helloService;
    private Aspect aspect = new TransactionAspect();

    public InvocationHandlerImpl(HelloServiceImpl helloService) {
        this.helloService = helloService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        aspect.before();
        method.invoke(helloService, args);
        aspect.after();
        return null;
    }
}
