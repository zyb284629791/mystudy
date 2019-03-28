package com.john;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-11 15:02
 */
@Service
public class HelloService {

    @Autowired
    private HelloDao helloRepostory;

    @Autowired
    private TestDao testDao;

    public void sayHello(String name){
        helloRepostory.sayHello(name);
    }

    public void test(){
        testDao.test();
    }
}
