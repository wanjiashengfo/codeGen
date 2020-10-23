package com.guide.factory.factoryMethod;

import com.guide.factory.Car;
import com.guide.factory.Benz;

//具体工厂角色
public class BenzDriver implements MyDriver{
    @Override
    public Car driverCar() {
        return new Benz();
    }
}
