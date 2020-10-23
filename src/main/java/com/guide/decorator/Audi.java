package com.guide.decorator;
//Audi车子类
public class Audi extends CarParent{

    @Override
    public void printFace() {
        System.out.println("奥迪默认颜色为：黑色");
    }
}
