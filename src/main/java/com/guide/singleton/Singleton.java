package com.guide.singleton;

public class Singleton {
    //唯一实例
    private static Singleton singleton = null;
    //将构造方法设置为私有
    private Singleton(){

    }
    //初始化唯一实例并返回
    public static Singleton instance(){
        if(singleton==null){
            singleton = new Singleton();
           return singleton;
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.instance());
        System.out.println(Singleton.instance());
    }
}
