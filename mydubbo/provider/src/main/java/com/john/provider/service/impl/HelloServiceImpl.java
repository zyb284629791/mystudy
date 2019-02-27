package com.john.provider.service.impl;


import com.john.provider.api.HelloService;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-26 15:29
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String guestName) {
        StringBuilder sb = new StringBuilder();
        sb.append("hello ");
        sb.append(guestName);
        return sb.toString();
    }
}
