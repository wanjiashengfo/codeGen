package com.guide.factory;

import com.guide.factory.Car;

//具体产品角色
public class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("Driving Audi");
    }
}
