package com.guide.factory.factoryMethod;

import com.guide.factory.Car;

public class Test {
    public static void main(String[] args) {
        MyDriver driver = new BenzDriver();
        Car car = driver.driverCar();
        car.drive();
    }
}
