package com.john.mvc;

import com.john.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @Author: 张彦斌
 * @Date: 2019-04-03 10:57
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String sayHello(@RequestParam String guests){
        helloService.sayHello(guests);
        return "success";
    }

    @GetMapping("/hellos")
    public String sayHello(@RequestParam String[] guests){
        Arrays.asList(guests).forEach( guest -> {
            helloService.sayHello(guest);
        });
        return "success";
    }

    @GetMapping("/hello/{guest}")
    public String sayHello2(@PathVariable String guest){
        helloService.sayHello(guest);
        return "success";
    }
}
