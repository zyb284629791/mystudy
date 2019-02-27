package com.john;

import com.john.protocol.MyProtocol;
import com.john.protocol.ProtocolFactory;
import com.john.register.URL;
import com.john.provider.api.HelloService;
import com.john.provider.service.impl.HelloServiceImpl;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-26 15:40
 */
public class Provider {

    public static void main(String[] args) {
        URL url = new URL("localhost",8080);
        // 注册服务
        MapRegister.registe(HelloService.class.getName(),url, HelloServiceImpl.class);
        // 启动服务
        MyProtocol protocol = ProtocolFactory.newProtocol();
        protocol.start(url);
    }
}
