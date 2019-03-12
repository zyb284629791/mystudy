package com.john.designpatten.proxy;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-12 14:22
 */
public class TransactionAspect implements Aspect {
    @Override
    public void before() {
        System.out.println("start transaction");
    }

    @Override
    public void after() {
        System.out.println("commit transaction");
    }
}
