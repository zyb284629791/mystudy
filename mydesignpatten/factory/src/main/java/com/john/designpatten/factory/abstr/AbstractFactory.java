package com.john.designpatten.factory.abstr;

import com.john.designpatten.factory.Car;
import com.john.designpatten.factory.func.AudiFactory;
import com.john.designpatten.factory.func.BenzFactory;
import com.john.designpatten.factory.func.BmwFactory;

/**
 * 与工厂方法相比，抽象工厂添加了动态切换工厂的可能性，同时提供了默认工厂实现。
 * 不用自己去创建工厂。
 * @Author: 张彦斌
 * @Date: 2019-03-12 11:17
 */
public abstract class AbstractFactory {

    protected abstract Car getCar();

    protected Car getCar(String name){
        switch (name) {
            case "BMW":
                return new BmwFactory().getCar();
            case "Benz":
                return new BenzFactory().getCar();
            case "Audi":
                return new AudiFactory().getCar();
            default:
                System.out.println("没有技术生产该汽车");
                return null;
        }
    }
}
