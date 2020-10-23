package com.guide.composite;
//具体部件 磁盘
public class Disk extends Equipment{
    public Disk(String name) {
        super(name);
    }

    @Override
    public double price() {
        return 400;
    }
}
