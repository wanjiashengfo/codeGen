package com.guide.visitor;
//人事部门 具体的被访问结点
public class PartB implements Visitable{
    String s = "人事部门";
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    public String getName(){
        return s;
    }
}
