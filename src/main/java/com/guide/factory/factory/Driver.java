package com.guide.factory.factory;

import com.guide.factory.Audi;
import com.guide.factory.Benz;
import com.guide.factory.Bmw;
import com.guide.factory.Car;

//工厂类角色
public class Driver {
    //工厂方法 返回类型为抽象产品角色
    public static Car driveCar(String s) throws Exception {
        //判断逻辑 返回具体的产品角色给client
        if(s.equalsIgnoreCase("Benz")){
            return new Benz();
        }else if(s.equalsIgnoreCase("Bmw")){
            return new Bmw();
        }else if(s.equalsIgnoreCase("Audi")){
            return new Audi();
        }else {
            throw new Exception();
        }
    }
}
