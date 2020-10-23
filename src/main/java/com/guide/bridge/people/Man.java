package com.guide.bridge.people;

public class Man extends AbstractPeople{
    @Override
    public void run() {
        System.out.print("男人开着");
        getRoad().run();
    }
}
