package com.guide.composite;
//具体部件 磁盘
public class Cpu extends Equipment{
    public Cpu(String name) {
        super(name);
    }

    @Override
    public double price() {
        return 500;
    }
}
