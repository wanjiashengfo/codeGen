package com.guide.adapter;
//适配器类(充电器)
public class Adapter extends Power implements ITarget{
    //得到想要电压
    @Override
    public void GetPower() {
        this.GetPower220V();
        System.out.println("Get cellphone power");
    }
}
