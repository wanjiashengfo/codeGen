package com.guide.bridge.car;

import com.guide.bridge.car.AbstractCar;

//公共汽车
public class Bus extends AbstractCar {
    @Override
    public void run() {
        System.out.print("公共汽车在");
    }
}
