package com.john;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-05 10:36
 */
public class SpringStudy {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        helloService.sayHello("John");
    }
}
