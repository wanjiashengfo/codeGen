package com.guide.bridge.road;

import com.guide.bridge.road.AbstractRoad;

//高速公路
public class SpeedWay extends AbstractRoad {
    @Override
    public void run() {
        getCar().run();
        System.out.println("高速公路上行驶");
    }
}
