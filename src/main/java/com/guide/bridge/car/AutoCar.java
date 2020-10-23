package com.guide.bridge.car;

import com.guide.bridge.car.AbstractCar;

//小汽车
public class AutoCar extends AbstractCar {
    @Override
    public void run() {
        System.out.print("小汽车在");
    }
}
