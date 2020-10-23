package com.guide.composite;
//具体部件 磁盘
public class Screen extends Equipment{
    public Screen(String name) {
        super(name);
    }

    @Override
    public double price() {
        return 1000;
    }
}
