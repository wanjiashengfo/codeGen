package com.guide.factory.factoryMethod;

import com.guide.factory.Car;
import com.guide.factory.Bmw;

//具体工厂角色
public class BmwDriver implements MyDriver{
    @Override
    public Car driverCar() {
        return new Bmw();
    }
}
