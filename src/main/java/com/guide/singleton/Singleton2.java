package com.guide.singleton;

public class Singleton2 {
    //直接初始化
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2(){}

    public static Singleton2 instance(){
        return singleton2;
    }

    public static void main(String[] args) {
        System.out.println(Singleton2.instance());
        System.out.println(Singleton2.instance());
    }
}
