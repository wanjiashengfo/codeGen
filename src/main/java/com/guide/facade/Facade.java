package com.guide.facade;

public class Facade {
    //定义赛车的统一接口 接口中封装了赛车启动需要的各种动作
    public void car_go(ACar car){
        car.check_box();
        car.check_console();
        car.check_stop();
        car.start();
    }
}
