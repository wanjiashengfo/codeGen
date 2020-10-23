package com.guide.builder;
//Director构建最后的复杂对象 即将部件最后组装成品
public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    //将方向盘 车轮 发动机 组装成汽车
    public void construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
