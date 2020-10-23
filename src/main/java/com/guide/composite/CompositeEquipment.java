package com.guide.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeEquipment extends Equipment{
    private int i = 0;
    //定义一个vector，用来存放儿子
    private List equipment = new ArrayList();
    public CompositeEquipment(String name) {
        super(name);
    }

    public boolean add(Equipment equipment){
        this.equipment.add(equipment);
        return true;
    }
    //提供用于访问自己组合体内的部件方法
    @Override
    public double price(){
        double price = 0;
        Iterator iterator = equipment.iterator();
        while (iterator.hasNext()){
            price += ((Equipment)iterator.next()).price();
        }
        return price;
    }


}
