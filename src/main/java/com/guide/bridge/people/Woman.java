package com.guide.bridge.people;

public class Woman extends AbstractPeople{
    @Override
    public void run() {
        System.out.print("女人开着");
        getRoad().run();
    }
}
