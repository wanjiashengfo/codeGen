package com.guide.prototype;

public class Test {
    public static void main(String[] args) {
        Sunwukong sunwukong1 = new Sunwukong(158, 45, 24);
        //通过克隆 得到第二个
        Sunwukong sunwukong2 = (Sunwukong)sunwukong1.clone();
        System.out.println(sunwukong1);
        System.out.println(sunwukong2);
    }
}

