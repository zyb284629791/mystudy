package com.john.designpatten.factory.abstr;

import com.john.designpatten.factory.Car;
import com.john.designpatten.factory.func.BenzFactory;
import com.john.designpatten.factory.func.CarFactory;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-12 11:18
 */
public class DefaultFactory extends AbstractFactory {

    private final CarFactory defaultCarFactory = new BenzFactory();

    @Override
    protected Car getCar() {
        return defaultCarFactory.getCar();
    }
}
