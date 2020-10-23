package com.guide.singleton;
//直接枷锁
public class Singleton3 {
    private static Singleton3 singleton3 = null;
    private Singleton3(){}

    public static synchronized Singleton3 instance(){
        if(singleton3==null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
    public static void main(String[] args) {
        System.out.println(Singleton3.instance());
        System.out.println(Singleton3.instance());
    }
}
