package com.guide.bridge;

import com.guide.bridge.car.AutoCar;
import com.guide.bridge.car.Bus;
import com.guide.bridge.people.AbstractPeople;
import com.guide.bridge.people.Man;
import com.guide.bridge.people.Woman;
import com.guide.bridge.road.AbstractRoad;
import com.guide.bridge.road.SpeedWay;
import com.guide.bridge.road.Street;

public class TestBridge {
    public static void main(String[] args) {
        //小汽车在高速公路上行驶
        AbstractRoad road1 = new SpeedWay();
        road1.setCar(new AutoCar());
        AbstractPeople people1 = new Man();
        people1.setRoad(road1);
        people1.run();
        System.out.println("===========");
        //公共车在市区街道上行驶
        AbstractRoad road2 = new Street();
        road2.setCar(new Bus());
        AbstractPeople people2 = new Woman();
        people2.setRoad(road2);
        people2.run();
        System.out.println("===========");
    }
}
