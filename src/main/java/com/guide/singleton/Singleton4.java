package com.guide.singleton;
//双重枷锁
public class Singleton4 {
    private volatile static Singleton4 singleton4=null;
    private Singleton4(){}
    public static Singleton4 getInstance(){
        if(singleton4==null){
            synchronized (Singleton4.class){
                singleton4 = new Singleton4();
            }
        }
        return singleton4;
    }
    public static void main(String[] args) {
        System.out.println(Singleton4.getInstance());
        System.out.println(Singleton4.getInstance());
    }
}
