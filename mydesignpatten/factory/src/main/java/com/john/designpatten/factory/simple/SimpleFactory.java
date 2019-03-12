package com.john.designpatten.factory.simple;

import com.john.designpatten.factory.Audi;
import com.john.designpatten.factory.Benz;
import com.john.designpatten.factory.Bmw;
import com.john.designpatten.factory.Car;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-12 11:05
 */
public class SimpleFactory {

    public Car getCar(String name) {
        switch (name) {
            case "BMW":
                return new Bmw();
            case "Benz":
                return new Benz();
            case "Audi":
                return new Audi();
            default:
                System.out.println("没有技术生产该汽车");
                return null;
        }
    }

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        System.out.println(simpleFactory.getCar("BMW").getName());
    }
}
