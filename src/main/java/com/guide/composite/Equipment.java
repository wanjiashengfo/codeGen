package com.guide.composite;

import java.util.Iterator;

//部件接口 提供通用方法
public abstract class Equipment {
    private String name;
    //价格
    public abstract double price();
    //增加部件方法
    public boolean add(Equipment equipment){
        return false;
    }
    //删除部件方法
    public boolean remove(Equipment equipment){
        return false;
    }
    //这里提供一种用于访问组合体类的部件方法
    public Iterator iter(){
        return null;
    }
    public Equipment(final String name){
        this.name = name;
    }
}
