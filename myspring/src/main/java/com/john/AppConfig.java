package com.john;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.sql.Driver;
import java.util.Properties;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-11 15:01
 */
@Configuration
//@EnableWebMvc
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public TestDao testDao(){
        return new TestDao();
    }

    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        Properties properties = new Properties();
        properties.setProperty("url", "jdbc:mysql://localhost:3306/study-test?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
        properties.setProperty("username", "root");
        properties.setProperty("password", "root#root");
//        Driver driver =
//        druidDataSource.setDriver();
        druidDataSource.setConnectProperties(properties);
        return druidDataSource;
    }
}
