package com.guide.visitor;
//总经理 访问者的具体实现
public class CEO implements Visitor{
    @Override
    public void visit(PartA a) {
        System.out.println("总经理管理"+a.getName());
    }

    @Override
    public void visit(PartB b) {
        System.out.println("总经理管理"+b.getName());
    }
}
