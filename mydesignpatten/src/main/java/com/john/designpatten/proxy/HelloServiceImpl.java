package com.john.designpatten.proxy;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-12 14:19
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello(String name){
        System.out.printf("Hello %s\n",name);
    }
}
