package com.guide.bridge.road;

import com.guide.bridge.road.AbstractRoad;

//市区街道
public class Street extends AbstractRoad {
    @Override
    public void run() {
        getCar().run();
        System.out.println("市区街道上行驶");
    }
}
