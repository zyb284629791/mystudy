package com.john;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-25 16:44
 */
@Repository
public class HelloDao {

    private String defaultName = "Java";

    public void sayHello(String name){
        System.out.printf("Hello %s \n", StringUtils.isEmpty(name) ? defaultName : name);
    }
}
