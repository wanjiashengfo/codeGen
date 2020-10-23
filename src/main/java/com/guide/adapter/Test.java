package com.guide.adapter;

public class Test {
    public static void main(String[] args) {
        System.out.println("手机");
        ITarget target = new Adapter();
        target.GetPower();
    }
}
