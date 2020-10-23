package com.guide.builder;

public class ConcreateBuilder implements Builder{
    Part partA,partB,partC;
    @Override
    public void buildPartA() {
        this.partA = new Part("车轮");
    }

    @Override
    public void buildPartB() {
        this.partB= new Part("方向盘");
    }

    @Override
    public void buildPartC() {
        this.partC = new Part("发动机");
    }

    @Override
    public Product getResult() {
        System.out.println("汽车成品 组成："+partA.getPartName()+partB.getPartName()+partC.getPartName());
        return new Product(partA,partB,partC);
    }
}
