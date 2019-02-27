package com.john.protocol;

import com.john.protocol.invocation.Invocation;
import com.john.register.URL;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-27 10:13
 */
public interface MyProtocol {

    void start(URL url);

    String send(URL url, Invocation invocation);
}
