package com.guide.factory;

import com.guide.factory.Car;

//具体产品角色
public class Bmw implements Car {
    @Override
    public void drive() {
        System.out.println("Driving Bmw");
    }
}
