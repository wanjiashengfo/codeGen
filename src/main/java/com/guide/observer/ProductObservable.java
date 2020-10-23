package com.guide.observer;

import lombok.Getter;

import java.util.Observable;
//想要观察的对象 即产品
@Getter
public class ProductObservable extends Observable {

    private String name;
    private float price;

    public void setName(String name){
        this.name = name;
        setChanged();//设置变化点
        notifyObservers(name);//通知所有观察者 自动调用观察者的update方法
    }
    public void setPrice(float price){
        this.price = price;
        setChanged();//设置变化点
        notifyObservers(new Float(price));//通知所有观察者 自动调用观察者的update方法
    }
}
