package com.john.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component // 因为@Aspect不是Spring的注解，因此需要加上@Component来让Spring能够自动扫描到切面
public class NotVeryUsefulAspect {

    @Before("execution(* com.john.*Service.*(..))")
    public void before(JoinPoint jp){
        System.out.println("before");
        System.out.println(Arrays.asList(jp.getArgs()));
        System.out.println(jp.getSignature());
        System.out.println(jp.getTarget());
        System.out.println(jp.getThis());
    }

    @Around("within(com.john.*Service)")
    public void around(ProceedingJoinPoint pjp){
        System.out.printf("before %s\n",pjp.getSignature());
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.printf("after %s\n",pjp.getSignature());
    }
}
