package com.john.protocol;


import com.john.protocol.http.MyHttpProtocol;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-27 10:25
 */
public class ProtocolFactory {

    public static MyProtocol newProtocol(){
        String protocolName = System.getProperty("protocol", "http");
        MyProtocol protocol = null;
        switch (protocolName){
            case "http":
                protocol = new MyHttpProtocol();
                break;
            case "dubbo":
                throw new RuntimeException("not support yet");
        }

        return protocol;
    }
}
