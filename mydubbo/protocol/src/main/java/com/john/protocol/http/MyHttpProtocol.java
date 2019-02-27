package com.john.protocol.http;

import com.john.protocol.MyProtocol;
import com.john.protocol.invocation.Invocation;
import com.john.register.URL;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-27 10:21
 */
public class MyHttpProtocol implements MyProtocol {

    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(),url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.post(url.getHostName(),url.getPort(),invocation);
    }
}
