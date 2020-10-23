package com.guide.factory.factory;

import com.guide.factory.Car;

public class TestDrive {
    public static void main(String[] args) {
        try {
            //告诉司机我今天坐奔驰
            Car car = Driver.driveCar("Benz");
            //下命令 开车
            car.drive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
