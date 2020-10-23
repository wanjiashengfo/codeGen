package com.guide.builder;
//定义一个接口用来建复杂对象的各个部件
public interface Builder {
    //创建部件A 比如创建汽车车轮
    void buildPartA();
    //创建部件B 比如创建方向盘
    void buildPartB();
    //创建部件C 比如创建发动机
    void buildPartC();
    //返回最后装配好的汽车
    Product getResult();
}
