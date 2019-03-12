package com.john;


import org.springframework.stereotype.Service;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-11 15:02
 */
@Service
public class HelloService {

    public void sayHello(String name){
        System.out.printf("Hello %s \n", name);
    }
}
