package com.john;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-11 15:01
 */
@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public TestDao testDao(){
        return new TestDao();
    }
}
