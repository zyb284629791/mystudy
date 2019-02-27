package com.john.consumer.proxy;

import com.john.MapRegister;
import com.john.protocol.invocation.Invocation;
import com.john.protocol.MyProtocol;
import com.john.protocol.ProtocolFactory;
import com.john.register.URL;

import java.lang.reflect.Proxy;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-26 16:56
 */
public class ProxyFactory  {

    public static <T> T getProxy(Class interfaceClass){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, (proxy, method, args) -> {
            MyProtocol protocol = ProtocolFactory.newProtocol();
            Invocation invocation = new Invocation(interfaceClass.getName(),method.getName(),args,method.getParameterTypes());
            URL url = MapRegister.getURL(interfaceClass.getName());
            String result = protocol.send(url, invocation);
            return result;
        });
    }
}
