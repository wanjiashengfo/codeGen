package com.guide.observer;

import java.util.Observable;
import java.util.Observer;
//观察者nameobserver主要用来对产品名称name进行观察
public class NameObserver implements Observer {
    private String name = null;
    @Override
    public void update(Observable obs, Object obj) {
        if(obj instanceof  String){
            name = (String)obj;
            System.out.println("nameobserver:name change to " + name);
        }
    }
}
