package com.john.designpatten.factory.abstr;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-12 11:21
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactory abstractFactory = new DefaultFactory();
        System.out.println(abstractFactory.getCar().getName());

        System.out.println(abstractFactory.getCar("Audi").getName());
    }
}
