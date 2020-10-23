package com.guide.observer;

import java.util.Observable;
import java.util.Observer;

//观察者PriceObserver主要用来对产品名称Price进行观察
public class PriceObserver implements Observer {
    private float price = 0;
    @Override
    public void update(Observable obs, Object obj) {
        if(obj instanceof  Float){
            price = ((Float)obj).floatValue();
            System.out.println("nameobserver:price change to " + price);
        }
    }
}
