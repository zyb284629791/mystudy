package com.john.designpatten.factory.func;

/**
 * 与简单工厂相比，工厂方法模式是将各工厂独立出来，因为简单工厂太万能，可以同时生产各种品牌的汽车
 * 而工厂方法则将各品牌拆开，各自负责自己的汽车生产，缺点是不能动态修改厂商，只能做到要哪个new哪个
 * 无法使用统一接口来简化操作。
 * @Author: 张彦斌
 * @Date: 2019-03-12 11:22
 */
public class CarFunctionTest {

    public static void main(String[] args) {
        CarFactory carFactory = new AudiFactory();
        System.out.println(carFactory.getCar().getName());

        carFactory = new BenzFactory();
        System.out.println(carFactory.getCar().getName());
    }
}
