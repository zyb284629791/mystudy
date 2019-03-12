package com.john.designpatten.factory.func;

import com.john.designpatten.factory.Benz;
import com.john.designpatten.factory.Car;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-12 11:07
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
