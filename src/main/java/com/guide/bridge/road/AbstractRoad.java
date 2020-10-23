package com.guide.bridge.road;

import com.guide.bridge.car.AbstractCar;
import lombok.Data;
//抽象路
@Data
public abstract class AbstractRoad {
    private AbstractCar car;
    public abstract void run();
}
